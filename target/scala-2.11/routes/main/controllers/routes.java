
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/esra/golang/src/github.com/esrakarakas/web-api-with-scala-play/conf/routes
// @DATE:Mon Jan 13 17:15:16 EET 2020

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseApplication Application = new controllers.ReverseApplication(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseApplication Application = new controllers.javascript.ReverseApplication(RoutesPrefix.byNamePrefix());
  }

}
