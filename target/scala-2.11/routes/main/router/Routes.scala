
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/esra/golang/src/github.com/esrakarakas/web-api-with-scala-play/conf/routes
// @DATE:Mon Jan 13 17:15:16 EET 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:5
  Application_0: controllers.Application,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    Application_0: controllers.Application
  ) = this(errorHandler, Application_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Application.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """contacts/$name<[^/]+>""", """controllers.Application.selectPerson(name:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """contacts""", """controllers.Application.insertPerson"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:5
  private[this] lazy val controllers_Application_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index0_invoker = createInvoker(
    Application_0.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """""",
      this.prefix + """"""
    )
  )

  // @LINE:6
  private[this] lazy val controllers_Application_selectPerson1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("contacts/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_selectPerson1_invoker = createInvoker(
    Application_0.selectPerson(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "selectPerson",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """contacts/$name<[^/]+>"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_Application_insertPerson2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("contacts")))
  )
  private[this] lazy val controllers_Application_insertPerson2_invoker = createInvoker(
    Application_0.insertPerson,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "insertPerson",
      Nil,
      "POST",
      """""",
      this.prefix + """contacts"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:5
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(Application_0.index)
      }
  
    // @LINE:6
    case controllers_Application_selectPerson1_route(params) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        controllers_Application_selectPerson1_invoker.call(Application_0.selectPerson(name))
      }
  
    // @LINE:7
    case controllers_Application_insertPerson2_route(params) =>
      call { 
        controllers_Application_insertPerson2_invoker.call(Application_0.insertPerson)
      }
  }
}