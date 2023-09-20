package com.nhungtester.beginer.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class Login {
    public static final Target LOGIN_HREF = Target.the("login href")
            .locatedBy("//a[@id='login2']");
    public static final Target LOGIN_USERNAME_TEXTBOX = Target.the("username textbox")
            .locatedBy("//input[@id='loginusername']");
    public static final Target LOGIN_PASSWORD_TEXTBOX = Target.the("password textbox")
            .locatedBy("//input[@id='loginpassword']");
    public static final Target LOG_IN_BUTTON = Target.the("login button")
            .locatedBy("//button[@class='btn btn-primary' and text()='Log in']");

    public static Performable loginAsNormalUser(String username, String password) {
        return Task.where("{0} login as normal user", actor -> actor.attemptsTo(
                Click.on(LOGIN_HREF),
                Enter.theValue(username).into(LOGIN_USERNAME_TEXTBOX),
                Enter.theValue(password).into(LOGIN_PASSWORD_TEXTBOX),
                Click.on(LOG_IN_BUTTON)
        ));
    }
}
