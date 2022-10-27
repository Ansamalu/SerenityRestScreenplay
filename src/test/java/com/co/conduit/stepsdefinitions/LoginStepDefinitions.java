package com.co.conduit.stepsdefinitions;

import com.co.conduit.models.credentials.User_H;
import com.co.conduit.questions.LoginValidation;
import com.co.conduit.questions.ResponseCode;
import com.co.conduit.tasks.LoginPost;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.co.conduit.utils.Constants.*;
import static org.hamcrest.Matchers.equalTo;

public class LoginStepDefinitions {
    Actor Sara = Actor.named("Sara");


    @Given("he is a user registed and can login")
    public void heIsAUserRegistedAndCanLogin() {
        Sara.whoCan(CallAnApi.at(URL));

    }

    @When("he send the credencials of access {string} and {string}")
    public void heSendTheCredencialsOfAccessEmailAndPassword(String email, String password) {
        User_H user_h = new User_H();
        user_h.setEmail(email);
        user_h.setPassword(password);
        Sara.attemptsTo(LoginPost.cosume(user_h));

    }

    @Then("he access to the page")
    //Si se muestra amarillo es por que no hemos especificado el tipo de dato
    public void heAccessToThePage() {
        //Vamos a realizar una asercion
        Sara.should(GivenWhenThen.seeThat(VALIDATE_STATUS,
                ResponseCode.status(),equalTo(200)));
        Sara.should(GivenWhenThen.seeThat(VALIDATE_LOGIN,
                LoginValidation.validate(),equalTo("jarv078@gmail.com")));

    }
}







