package page_objects.research;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page_interfaces.research.CarDimensionPageUI;
import page_objects.CommonPage;
import page_objects.PageInitManager;

public class CarDimensionPage extends CommonPage {
    WebDriver driver;

    public CarDimensionPage (WebDriver driver) {
        this.driver = driver;
    }

    @Step("Select to Make dropdown with Make = {1}")
    public void selectToMakeDropdown(WebDriver driver, String make) {
        waitForElementClickable(driver, CarDimensionPageUI.MAKE_FILTER_DROPDOWN);
        selectItemInDropDown(driver, CarDimensionPageUI.MAKE_FILTER_DROPDOWN, make);
    }

    @Step("Select to Model dropdown with Model = {1}")
    public void selectToModelDropdown(WebDriver driver, String model) {
        waitForElementClickable(driver, CarDimensionPageUI.MODEL_FILTER_DROPDOWN);
        selectItemInDropDown(driver, CarDimensionPageUI.MODEL_FILTER_DROPDOWN, model);
    }

    @Step("Select to Year dropdown with Year = {1}")
    public void selectToYearDropdown(WebDriver driver, String year) {
        waitForElementClickable(driver, CarDimensionPageUI.YEAR_FILTER_DROPDOWN);
        selectItemInDropDown(driver, CarDimensionPageUI.YEAR_FILTER_DROPDOWN, year);
    }

    @Step("Click to Show Dimensions Button")
    public ShowDimensionPage clickToShowDimensionsButton(WebDriver driver) {
        waitForElementClickable(driver, CarDimensionPageUI.SHOW_DIMENSIONS_BUTTON);
        clickToElement(driver, CarDimensionPageUI.SHOW_DIMENSIONS_BUTTON);
        return PageInitManager.getPageInitManager().getShowDimensionPage(driver);
    }
}
