
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/esra/golang/src/github.com/esrakarakas/web-api-with-scala-play/conf/routes
// @DATE:Mon Jan 13 17:15:16 EET 2020


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
