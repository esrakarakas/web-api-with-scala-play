package models

import play.api.Play
import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.db.slick.DatabaseConfigProvider
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import slick.driver.JdbcProfile
import slick.driver.MySQLDriver.api._

case class Person(id: Option[Long] = null, name: String, lastName: String, phone1: Option[String], phone2: Option[String])

object Person {  
  implicit val personFormat = Json.format[Person]
}

class PersonTableDef(tag: Tag) extends Table[Person](tag, "person") {
  def id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)

  def name = column[String]("name")

  def lastName = column[String]("lastName")

  def phone1 = column[Option[String]]("phone1")

  def phone2 = column[Option[String]]("phone2")

  override def * =
    (id, name, lastName, phone1, phone2) <>((Person.apply _).tupled, Person.unapply)
}


object Persons {
  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)
  val persons = TableQuery[PersonTableDef]

  def listAll: Future[Seq[Person]] = dbConfig.db.run(persons.result)

  def select(name: String): Future[Seq[Person]] = dbConfig.db.run {
    persons.filter(p => p.name === name).result
  }

  def insert(name: String, lastName: String, phone1: Option[String]): Future[Person] = dbConfig.db.run {
    //persons.filter(p => p.name === name).map(p => (p.phone1)).result
    (persons.map(p => (p.name, p.lastName, p.phone1, p.phone2))
      returning persons.map(_.id)
      into ((namePhone, id)  => Person(id, namePhone._1, namePhone._2,namePhone._3, namePhone._4))
    ) += (name, lastName, phone1, null)
  }
}


