package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.json.Reads._
import scala.concurrent.ExecutionContext.Implicits.global
import services.PersonService 
import java.lang.ProcessBuilder.Redirect
import scala.concurrent.{ExecutionContext, Future}
import models.Person
import scala.io.Source
import play.api.libs.functional.syntax._

class Application extends Controller {
  def index = Action.async {
    PersonService.listAllPersons map { persons =>
      Ok(Json.toJson(persons))
    }
  }
  def selectPerson(name: String) = Action.async {
    implicit request =>
      PersonService.selectPerson(name) map { persons =>
        Ok(Json.toJson(persons))
      }
  }
  def reads(json: JsValue): JsResult[Person] = {
    val id = (json \ "id").as[Long]
    val name = (json \ "name").as[String]
    val lastName = (json \ "lastName").as[String]
    val phone1 = (json \ "phone1").as[String]
    val phone2 = (json \ "phone2").as[String]
    JsSuccess(Person(null, name, lastName, null, null))
  }
  def insertPerson = Action { request =>
    val json = request.body.asJson.get
    val prs = json.as[Person]
    PersonService.insertPerson(prs.name, prs.lastName, prs.phone1)
    Ok("SEND\n"+ Json.toJson(prs))
  }
}
    
  

 

