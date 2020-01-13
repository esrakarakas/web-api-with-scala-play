
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/esra/golang/src/github.com/esrakarakas/web-api-with-scala-play/conf/routes
// @DATE:Mon Jan 13 17:15:16 EET 2020

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:5
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:5
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:7
    def insertPerson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.insertPerson",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "contacts"})
        }
      """
    )
  
    // @LINE:6
    def selectPerson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.selectPerson",
      """
        function(name) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "contacts/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", encodeURIComponent(name))})
        }
      """
    )
  
  }


}