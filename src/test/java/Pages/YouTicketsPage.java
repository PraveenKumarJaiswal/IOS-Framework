package Pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class YouTicketsPage extends BasePage {
    By page_title = MobileBy.AccessibilityId("Your Tickets");
    By buy_more_button = MobileBy.name("Buy more");

    public YouTicketsPage(IOSDriver<MobileElement> driver) {
        super(driver);
    }

    public YouTicketsPage wait_animation_completed() {
        waitClickable(page_title);
        int images_count = 2;
        int i = 0;
        int max_wait = 10;

        while (images_count > 1) {
            images_count = driver.findElements(By.className("XCUIElementTypeImage")).size();
            sleep(1000);
            if (i == max_wait) {
                break;
            }
            i++;
        }
        ts.takeScreenshot(driver, "animation_completed");

        return this;
    }

    public YouTicketsPage tap_buy_more_button() {
        tap(buy_more_button);

        return this;
    }

    public YouTicketsPage done_payment_succesfully_alert() {
        By payment_title = MobileBy.name("Payment Successful");
        waitPresence(payment_title);
        ts.takeScreenshot(driver, "wait_payment_succesfully_alert");
        By done = MobileBy.name("Done");
        tap(done);

        return this;
    }
}
