package page_objects.sell_car;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page_interfaces.sell_car.SellMyCarPageUI;
import page_objects.CommonPage;
import page_objects.PageInitManager;

public class SellMyCarPage extends CommonPage {
    WebDriver driver;

    public SellMyCarPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to 'No Number Plate' link")
    public SelectACarPage clickToNoNumberPlateLink(WebDriver driver) {
        waitForElementClickable(driver, SellMyCarPageUI.NO_NUMBER_PLATE_LINK);
        clickToElement(driver, SellMyCarPageUI.NO_NUMBER_PLATE_LINK);
        return PageInitManager.getPageInitManager().getSelectACarPage(driver);
    }
}
