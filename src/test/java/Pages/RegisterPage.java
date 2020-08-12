package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class RegisterPage extends BasePage {


    public RegisterPage(IOSDriver<MobileElement> driver) {
        super(driver);
    }

    public RegisterPage enter_username(String username) {
        sleep(1500);
        enterByClassAndText("XCUIElementTypeTextField", "username", username);
        sleep(2000);
        driver.findElement(MobileBy.name("Done")).click();
        ts.takeScreenshot(driver, "enter_username_" + username);

        return this;
    }

    public RegisterPage tap_continue() {
        sleep(2000);
        By continue_button = MobileBy.name("Continue");
        tap(continue_button);

        return this;
    }

    public RegisterPage tap_alert_done() {
        By continue_button = MobileBy.name("Done");
        tap(continue_button);

        return this;
    }

    public RegisterPage wait_empty_username_alert() {
        By user_name_empty = MobileBy.name("User name empty");
        waitPresence(user_name_empty);

        return this;
    }

    public RegisterPage wait_empty_phone_alert() {
        By invalid_phone_number = MobileBy.name("Invalid Phone Number");
        waitPresence(invalid_phone_number);

        return this;
    }

    public RegisterPage wait_not_valid_phone() {
        By invalid_phone_number = MobileBy.name("[HTTP 400] Unable to create record: The 'To' number +911111111111 is not a valid phone number.");
        waitPresence(invalid_phone_number);

        return this;
    }

    public RegisterPage enter_phone(String phone) {
        sleep(3000);
        enterByClassAndText("XCUIElementTypeTextField", "Your Phone", phone);
        sleep(2000);
        driver.findElement(MobileBy.name("Done")).click();
        ts.takeScreenshot(driver, "enter_phone_" + phone);

        return this;
    }

    public RegisterPage enter_code(String code) {
        sleep(3000);
        enterByClassAndText("XCUIElementTypeTextField", "Type Code Here", code);
        sleep(2000);
        driver.findElement(MobileBy.name("Done")).click();
        ts.takeScreenshot(driver, "enter_code" + code);

        return this;
    }
}
