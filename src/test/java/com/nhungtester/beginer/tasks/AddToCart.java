package com.nhungtester.beginer.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class AddToCart {
    public static final Target PHONES_LIST = Target.the("phone item")
            .locatedBy("//div[@class='list-group']/a[text()='Phones']");
    public static final Target SAMSUNG_GALAXY_S_6 = Target.the("samsung galaxy s6")
            .locatedBy("//a[text()='Samsung galaxy s6']");
    public static final Target ADD_TO_CART_BUTTON = Target.the("add to cart button")
            .locatedBy("//a[text()='Add to cart']");
    public static final Target LAPTOPS_LIST = Target.the("laptop item")
            .locatedBy("//a[text()='Laptops']");
    public static final Target MAC_BOOK_AIR = Target.the("MacBook air")
            .locatedBy("//a[text()='MacBook air']");

    public static Performable selectPhone() {
        return Task.where("{0} add phone to cart ", actor -> actor.attemptsTo(
                Click.on(PHONES_LIST),
                Click.on(SAMSUNG_GALAXY_S_6),
                Click.on(ADD_TO_CART_BUTTON)
        ));
    }

    public static Performable selectLaptop() {
        return Task.where("{0} add laptop to cart ", actor -> actor.attemptsTo(
                Click.on(LAPTOPS_LIST),
                Click.on(MAC_BOOK_AIR),
                Click.on(ADD_TO_CART_BUTTON)
        ));
    }
}
