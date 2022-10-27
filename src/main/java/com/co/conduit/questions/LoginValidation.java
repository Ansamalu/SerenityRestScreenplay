package com.co.conduit.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LoginValidation implements Question<String> {
    //Esta linea comentada es como una idea por si queremos capturar algo
   /* @Override
    public String answeredBy(Actor actor) {//con el string vamos a capturar el token
      String token= SerenityRest.lastResponse().path("user.token");//con el path le estoy diciendo que del user me mande el token
        return token;
    }
*/
    @Override
    public String answeredBy(Actor actor) {
       return SerenityRest.lastResponse().path("user.email");//con el path le estoy diciendo que del user me mande el token;
    }


    public static LoginValidation validate() {

        return new LoginValidation();
    }
}
