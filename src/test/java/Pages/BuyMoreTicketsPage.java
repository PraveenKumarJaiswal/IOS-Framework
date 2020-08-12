package Pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class BuyMoreTicketsPage extends BasePage{
    public BuyMoreTicketsPage(IOSDriver<MobileElement> driver) {
        super(driver);
    }

    public BuyMoreTicketsPage select_ticket_count(String count) {
        By ticket_count = By.name( count);
        waitPresence(ticket_count);
        tapOnCenterOfElement(driver.findElement(ticket_count));
        ts.takeScreenshot(driver, "select_ticket_count_" + count);

        return this;
    }

    public BuyMoreTicketsPage tap_next() {
        By next_button = By.name("Next");
        tap(next_button);

        return this;
    }
}
