package com.co.conduit.tasks;

import com.co.conduit.interactions.Post;
import com.co.conduit.models.credentials.Data_P;
import com.co.conduit.models.credentials.User_H;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class LoginPost implements Task {

    User_H user_h;
    public LoginPost(User_H user_h) {

        this.user_h = user_h;
    }
    Data_P data_p = new Data_P();



    @Override
    public <T extends Actor> void performAs(T actor) {
        data_p.setUser(user_h);
        actor.attemptsTo(
             Post.to("/users/login")
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(data_p))
        );
    }


    public static LoginPost cosume(User_H user_h) {
        return Tasks.instrumented(LoginPost.class , user_h);


    }
}
