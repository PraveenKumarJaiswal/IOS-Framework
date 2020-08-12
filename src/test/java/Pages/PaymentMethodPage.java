package Pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class PaymentMethodPage extends BasePage {
    public PaymentMethodPage(IOSDriver<MobileElement> driver) {
        super(driver);
    }

    public PaymentMethodPage select_card(String card_name) {
        By card = MobileBy.name(card_name);
        tap(card);
        ts.takeScreenshot(driver, "select_card_" + card_name);

        return this;
    }
}
