package Tests;

import Pages.MainPage;
import Pages.RegisterPage;
import TestFixtures.BaseTestFixture;
import org.junit.jupiter.api.Test;

public class RegisterTest extends BaseTestFixture {
    @Test
    public void Register() {
        new MainPage(driver)
                .accept_allert()
                .isInitialized()
                .tap_account_icon()
                .tap_register_allert_button();

        new RegisterPage(driver)
                .enter_username("TestUserName")
                .tap_continue()
                .enter_phone("7037597596")
                .tap_continue()
                .enter_code("1234")
                .tap_continue();

        new MainPage(driver)
                .dismiss_allert()
                .isInitialized();
    }
    @Test
    public void WrongFieldEntry() {
        new MainPage(driver)
                .accept_allert()
                .isInitialized()
                .tap_account_icon()
                .tap_register_allert_button();

        new RegisterPage(driver)
                .tap_continue()
                .wait_empty_username_alert()
                .tap_alert_done()
                .enter_username("CorrectNameTest")
                .tap_continue()

                .tap_continue()
                .wait_empty_phone_alert()
                .tap_alert_done()

                .enter_phone("1111111111")
                .tap_continue()
                .wait_not_valid_phone()
                .tap_alert_done();
    }
}
