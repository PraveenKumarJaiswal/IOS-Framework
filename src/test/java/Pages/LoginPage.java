package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.HideKeyboardStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginPage extends BasePage {
    public LoginPage(IOSDriver<MobileElement> driver) {
        super(driver);
    }

    public LoginPage enter_phone(String phone) {
        enterByClassAndText("XCUIElementTypeTextField", "Type your phone number here", phone);
        sleep(500);
        driver.findElement(MobileBy.name("Done")).click();
        ts.takeScreenshot(driver, "enter_phone_" + phone);

        return this;
    }

    public LoginPage enter_password(String password) {
        enterByClassAndText("XCUIElementTypeSecureTextField", "Password", password);
        sleep(500);
        driver.findElement(MobileBy.name("Done")).click();
        ts.takeScreenshot(driver, "enter_password_" + password);

        return this;
    }

    public LoginPage tap_login() {
        By continue_button = MobileBy.name("Continue");
        tap(continue_button);

        return this;
    }

    public LoginPage tap_alert_done() {
        By continue_button = MobileBy.name("Done");
        tap(continue_button);

        return this;
    }

    public LoginPage wait_auth_error_alert() {
        By authentication_failed = MobileBy.name("Authentication Failed");
        waitPresence(authentication_failed);

        return this;
    }
}
