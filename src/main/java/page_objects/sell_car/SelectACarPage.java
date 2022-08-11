package page_objects.sell_car;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page_interfaces.sell_car.SelectACarPageUI;
import page_objects.CommonPage;
import page_objects.PageInitManager;

public class SelectACarPage extends CommonPage {
    WebDriver driver;

    public SelectACarPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Select {1} = {2} in custom select dropdown")
    public void selectToInputDropdown(WebDriver driver, String selectName, String selectItem) {
        // enter to select-input dropdown
        waitForElementVisible(driver, SelectACarPageUI.DYNAMIC_INPUT_DROPDOWN, selectName);
        sendKeyToElement(driver, SelectACarPageUI.DYNAMIC_INPUT_DROPDOWN, selectItem, selectName);

        // select item
        waitForElementClickable(driver, SelectACarPageUI.DYNAMIC_SELECT_ITEM, selectName, selectItem);
        clickToElement(driver, SelectACarPageUI.DYNAMIC_SELECT_ITEM, selectName, selectItem);
    }

    @Step("Click to 'Create Your Free Ad' button")
    public SellDetailsPage clickToCreateYourFreeAdButton(WebDriver driver) {
        waitForElementClickable(driver, SelectACarPageUI.CREATE_YOUR_FREE_AD_BUTTON);
        clickToElement(driver, SelectACarPageUI.CREATE_YOUR_FREE_AD_BUTTON);
        return PageInitManager.getPageInitManager().getSellDetailsPage(driver);
    }
}
