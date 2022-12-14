package page_objects.home;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page_interfaces.home.HomePageUI;
import page_objects.CommonPage;
import page_objects.PageInitManager;
import page_objects.for_sale.ForSalePage;

public class HomePage extends CommonPage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter to Model Search Textbox with Model = {1}")
    public void enterToModelSearchTextbox(WebDriver driver, String model) {
        waitForElementVisible(driver, HomePageUI.MODEL_SEARCH_TEXTBOX);
        sendKeyToElement(driver, HomePageUI.MODEL_SEARCH_TEXTBOX, model);
    }

    @Step("Click to dropdown list to choose model = {1}")
    public void clickToModelSearchDropdown(WebDriver driver, String model) {
        waitForElementClickable(driver, HomePageUI.MEGA_DROPDOWN_ITEM, model);
        clickToElement(driver, HomePageUI.MEGA_DROPDOWN_ITEM, model);
    }

    @Step("Select Make = {1} in dropdown list")
    public void selectMakeInDropdown(WebDriver driver, String make) {
        waitForElementClickable(driver, HomePageUI.MAKE_SEARCH_TEXTBOX);
        sendKeyToElementByAction(driver, HomePageUI.MAKE_SEARCH_TEXTBOX, make);

        waitForElementClickable(driver, HomePageUI.MEGA_DROPDOWN_ITEM, make);
        clickToElement(driver, HomePageUI.MEGA_DROPDOWN_ITEM, make);
    }

    @Step("Select Model = {1} in dropdown list")
    public void selectModelInDropdown(WebDriver driver, String model) {
        waitForElementClickable(driver, HomePageUI.MODEL_SEARCH_TEXTBOX);
        sendKeyToElementByAction(driver, HomePageUI.MODEL_SEARCH_TEXTBOX, model);

        waitForElementClickable(driver, HomePageUI.MEGA_DROPDOWN_ITEM, model);
        clickToElement(driver, HomePageUI.MEGA_DROPDOWN_ITEM, model);
    }

    @Step("Click to Featured Searches = {1} in home page")
    public ForSalePage clickToFeaturedSearches(WebDriver driver, String featuredSearchName) {
        waitForElementClickable(driver, HomePageUI.FEATURED_SEARCH_LINK_ITEM, featuredSearchName);
        clickToElement(driver, HomePageUI.FEATURED_SEARCH_LINK_ITEM, featuredSearchName);
        return PageInitManager.getPageInitManager().getForSalePage(driver);
    }
}
