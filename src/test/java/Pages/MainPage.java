package Pages;

import Helpers.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.util.List;

public class MainPage extends BasePage {
    By account_icon = MobileBy.AccessibilityId("user");
    By more_ticket = MobileBy.AccessibilityId("Ticket");
    By login_allert_button = MobileBy.name("Login");
    By register_allert_button = MobileBy.name("Register");
    By new_ticket = MobileBy.name("newTicketon");
    By enter_allert_button = MobileBy.name("Enter");
    By feed_bottom = MobileBy.AccessibilityId("feedBottom");


    public MainPage(IOSDriver<MobileElement> driver) {
        super(driver);
    }

    public MainPage isInitialized() {
        waitPresence(feed_bottom);

        return this;
    }

    public MainPage accept_allert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        return this;
    }

    public MainPage dismiss_allert() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().dismiss();
        } catch (Exception e) {
            Log.info("No allerts");
        }

        return this;
    }

    public MainPage hide_white_page() {
        sleep(20000);
        ts.takeScreenshot(driver, "wait_white_page");
        swipe_top_to_down();
        sleep(200);
        waitPresence(feed_bottom);

        return this;
    }

    public MainPage tap_tickets() {
        waitPresence(feed_bottom);
//        tapByClassAndText("XCUIElementTypeStaticText", "Ticket");
        tapOnCenterOfElement(driver.findElement(By.name("Ticket")));
        ts.takeScreenshot(driver, "tap_tickets");

        return this;
    }

    public MainPage tap_new_ticket() {
        waitPresence(feed_bottom);
        tapOnCenterOfElement(driver.findElement(By.name("1")));
        ts.takeScreenshot(driver, "tap_new_ticket");

        return this;
    }

    public MainPage tap_enter() {
        tap(enter_allert_button);
        ts.takeScreenshot(driver, "tap_enter");
        sleep(3000);
        ts.takeScreenshot(driver, "buy_ticket_result");

        return this;
    }

    public MainPage tap_account_icon() {
        tap(account_icon);
        ts.takeScreenshot(driver, "tap_account_icon");

        return this;
    }

    public MainPage tap_login_allert_button() {
        tap(login_allert_button);
        ts.takeScreenshot(driver, "tap_login_allert_button");

        return this;
    }

    public MainPage tap_register_allert_button() {
        tap(register_allert_button);
        ts.takeScreenshot(driver, "tap_register_allert_button");

        return this;
    }
}
