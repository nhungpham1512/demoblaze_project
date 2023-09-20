package com.nhungtester.beginer.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class OrderItem {
    public static final Target CART_HREF = Target.the("cart href")
            .locatedBy("//a[@id ='cartur']");
    public static final Target PLACE_ORDER_BUTTON = Target.the("place order button")
            .locatedBy("//button[@class='btn btn-success']");
    public static final Target NAME_TEXTBOX = Target.the("name textbox")
            .locatedBy("//input[@id='name']");
    public static final Target COUNTRY_TEXTBOX = Target.the("country textbox")
            .locatedBy("//input[@id='country']");
    public static final Target CITY_TEXTBOX = Target.the("city textbox")
            .locatedBy("//input[@id='city']");
    public static final Target CREDIT_CARD_TEXTBOX = Target.the("credit card textbox")
            .locatedBy("//input[@id='card']");
    public static final Target MONTH_TEXTBOX = Target.the("month textbox")
            .locatedBy("//input[@id='month']");
    public static final Target YEAR_TEXTBOX = Target.the("year textbox")
            .locatedBy("//input[@id='year']");
    public static final Target PURCHASE_BUTTON = Target.the("purchase button")
            .locatedBy("//button[text()='Purchase']");

    public static final Target CLOSE_BUTTON = Target.the("close button")
            .locatedBy("//div[@id='orderModal']//button[text()='Close']");

    public static Performable placeOrderItem(String name, String country, String city, String creditCard, String month, String year) {
        return Task.where("{0} place order chosen item", actor -> actor.attemptsTo(
                Click.on(CART_HREF),
                Click.on(PLACE_ORDER_BUTTON),
                Enter.theValue(name).into(NAME_TEXTBOX),
                Enter.theValue(country).into(COUNTRY_TEXTBOX),
                Enter.theValue(city).into(CITY_TEXTBOX),
                Enter.theValue(creditCard).into(CREDIT_CARD_TEXTBOX),
                Enter.theValue(month).into(MONTH_TEXTBOX),
                Enter.theValue(year).into(YEAR_TEXTBOX),
                Click.on(PURCHASE_BUTTON)
        ));
    }
}
