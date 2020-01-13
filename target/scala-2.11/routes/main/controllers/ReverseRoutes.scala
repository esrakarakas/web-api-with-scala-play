
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/esra/golang/src/github.com/kocaKafaliEsra/conf/routes
// @DATE:Mon Jan 13 16:51:58 EET 2020

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:5
package controllers {

  // @LINE:5
  class ReverseApplication(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix)
    }
  
    // @LINE:7
    def insertPerson(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "contacts")
    }
  
    // @LINE:6
    def selectPerson(name:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "contacts/" + implicitly[PathBindable[String]].unbind("name", dynamicString(name)))
    }
  
  }


}