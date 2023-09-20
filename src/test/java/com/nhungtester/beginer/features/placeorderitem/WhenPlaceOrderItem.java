package com.nhungtester.beginer.features.placeorderitem;

import com.nhungtester.beginer.tasks.AddToCart;
import com.nhungtester.beginer.tasks.Login;
import com.nhungtester.beginer.tasks.OpenTheApplication;
import com.nhungtester.beginer.tasks.OrderItem;
import com.nhungtester.beginer.ui.HomePage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class WhenPlaceOrderItem {
    public static final Target SUCCESS_MSG = Target.the("success msg")
            .locatedBy("//div[@class='sa-icon sa-success animate']/following-sibling::h2");
    public static final Target CONFIRMATION_POPUP = Target.the("confirmation popup")
            .locatedBy("//p[@class ='lead text-muted ']");
    Actor tester = Actor.named("Nhung");
    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void testerCanBrowseTheWeb() {tester.can(BrowseTheWeb.with(herBrowser));
    }

    @WithTag("testcase:PlaceOrder01")
    @Test
    public void when_without_login_then_place_order_successfully() {
        tester.wasAbleTo(
                Open.url(HomePage.BASE_URL),
                AddToCart.selectPhone(),
                OrderItem.placeOrderItem("nhung", "VietNam", "HaNoi", "01223456", "12", "2026"),
                //Click.on(OrderItem.PLACE_ORDER_BUTTON),
                Ensure.that(SUCCESS_MSG).text().isEqualTo("Thank you for your purchase!"),
                //Ensure.that(CONFIRMATION_POPUP).text().contains("Id: 3618413"),
                Ensure.that(CONFIRMATION_POPUP).text().contains("Amount: 360 USD"),
                Ensure.that(CONFIRMATION_POPUP).text().contains("Card Number: 01223456"),
                Ensure.that(CONFIRMATION_POPUP).text().contains("Name: nhung"),
                Ensure.that(CONFIRMATION_POPUP).text().contains("Date: 20/8/2023")
                //system bug: date =20/8/2023
                );
    }

    @WithTag("testcase:PlaceOrder02")
    @Test
    public void when_login_as_member_then_place_order_successfully(){
        tester.wasAbleTo(
                Open.url(HomePage.BASE_URL),
                Login.loginAsNormalUser("junepham", "12345"),
                AddToCart.selectLaptop(),
                OrderItem.placeOrderItem("nhung", "VietNam", "HaNoi", "01223456", "8", "2023"),
                //Click.on(OrderItem.PLACE_ORDER_BUTTON),
                Ensure.that(SUCCESS_MSG).text().isEqualTo("Thank you for your purchase!"),
                //Ensure.that(CONFIRMATION_POPUP).text().contains("Id: 7716248"),
                Ensure.that(CONFIRMATION_POPUP).text().contains("Amount: 700 USD"),
                Ensure.that(CONFIRMATION_POPUP).text().contains("Card Number: 01223456"),
                Ensure.that(CONFIRMATION_POPUP).text().contains("Name: nhung"),
                Ensure.that(CONFIRMATION_POPUP).text().contains("Date: 20/8/2023")
                );
    }
/*    @WithTag("testcase:PlaceOrder03")
    @Test
    public void when_user_click_close_button_place_order_form_then_place_order_unsuccessfully(){
        tester.wasAbleTo(
                Open.url(HomePage.BASE_URL),
                Login.loginAsNormalUser("junepham", "12345"),
                AddToCart.selectLaptop(),
                OrderItem.placeOrderItem("nhung", "VietNam", "HaNoi", "01223456", "8", "2023"),
                Click.on(OrderItem.CLOSE_BUTTON),
                Ensure.thatTheCurrentPage().currentUrl().isEqualTo(HomePage.URL_CART)
        );
    }*/
}