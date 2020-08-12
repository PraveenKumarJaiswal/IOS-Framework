package Tests;

import Pages.*;
import TestFixtures.BaseTestFixture;
import org.junit.jupiter.api.Test;

public class BuyTicketTest extends BaseTestFixture {
    @Test
    public void BuyTicket() {
        new MainPage(driver)
                .accept_allert()
                .isInitialized()
                .tap_account_icon()
                .tap_login_allert_button();

        new LoginPage(driver)
                .enter_phone("8113970370")
                .enter_password("1234")
                .tap_login();

        new MainPage(driver)
                .dismiss_allert()
                .isInitialized()
                .tap_new_ticket()
                .tap_enter()
                .hide_white_page()
                .tap_tickets();

        new YouTicketsPage(driver)
                .wait_animation_completed()
                .tap_buy_more_button();

        new BuyMoreTicketsPage(driver)
                .select_ticket_count("5")
                .tap_next();

        new PaymentMethodPage(driver)
                .select_card("Visa Ending In 1111");

        new YouTicketsPage(driver)
                .done_payment_succesfully_alert();
    }
}
