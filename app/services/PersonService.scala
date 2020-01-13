package services

import scala.concurrent.Future

import models.{Person, Persons}

object PersonService {
  def listAllPersons: Future[Seq[Person]] = {
    Persons.listAll
  }
  def selectPerson(name: String): Future[Seq[Person]] = {
    Persons.select(name)
  }
  def insertPerson(name: String , lastName: String, phone1: Option[String]): Future[Person] = {
    Persons.insert(name, lastName, phone1)
  }
}
