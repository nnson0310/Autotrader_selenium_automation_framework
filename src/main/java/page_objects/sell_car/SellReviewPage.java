package page_objects.sell_car;

import helpers.FunctionHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page_interfaces.sell_car.SellReviewPageUI;
import page_objects.CommonPage;

import java.util.List;

public class SellReviewPage extends CommonPage {
    WebDriver driver;

    public SellReviewPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Verify that review vehicle title = {1} is displayed")
    public boolean isReviewVehicleTitleDisplayed(WebDriver driver, String reviewVehicleTitle) {
        waitForElementVisible(driver, SellReviewPageUI.REVIEW_VEHICLE_TITLE_LABEL_H1, reviewVehicleTitle);
        return isElementDisplayed(driver, SellReviewPageUI.REVIEW_VEHICLE_TITLE_LABEL_H1, reviewVehicleTitle);
    }

    @Step("Get number of uploaded images")
    public int getNumberOfUploadedImages(WebDriver driver) {
        waitForElementVisible(driver, SellReviewPageUI.UPLOADED_PHOTOS_STEP_INDICATOR_LABEL_P);
        return FunctionHelper.getStepIndicator(getElementText(driver, SellReviewPageUI.UPLOADED_PHOTOS_STEP_INDICATOR_LABEL_P).trim());
    }

    @Step("Click to 'View More Description' button")
    public void clickToViewMoreDescription(WebDriver driver) {
        scrollToElement(driver, SellReviewPageUI.VIEW_MORE_DESCRIPTION_BUTTON);
        waitForElementClickable(driver, SellReviewPageUI.VIEW_MORE_DESCRIPTION_BUTTON);
        clickToElementByJS(driver, SellReviewPageUI.VIEW_MORE_DESCRIPTION_BUTTON);
        FunctionHelper.sleepInSeconds(2);
    }

    @Step("Get full of review description content")
    public String getFullOfReviewDescription(WebDriver driver) {
        waitForElementVisible(driver, SellReviewPageUI.REVIEW_DESCRIPTION_LABEL_P);
        return getElementInnerText(driver, SellReviewPageUI.REVIEW_DESCRIPTION_LABEL_P);
    }

    @Step("Click to toggle 'Optional Extras'")
    public void clickToOptionalExtrasCollapse(WebDriver driver) {
        scrollToElement(driver, SellReviewPageUI.OPTIONAL_EXTRAS_COLLAPSE);
        waitForElementClickable(driver, SellReviewPageUI.OPTIONAL_EXTRAS_COLLAPSE);
        clickToElementByJS(driver, SellReviewPageUI.OPTIONAL_EXTRAS_COLLAPSE);
    }

    @Step("Verify that all checked optional extras = {1} are displayed")
    public boolean areCheckedOptionalExtrasDisplayed(WebDriver driver, String optionalExtrasText, List<String> optionalExtras) {
        boolean result = true;
        for(String optionalExtra: optionalExtras) {
            waitForElementVisible(driver, SellReviewPageUI.OPTIONAL_EXTRAS_COLLAPSE_LIST_ITEMS, optionalExtra);
            result = isElementDisplayed(driver, SellReviewPageUI.OPTIONAL_EXTRAS_COLLAPSE_LIST_ITEMS, optionalExtra);
        }
        return result;
    }

    @Step("Click to toggle 'Custom Modifications'")
    public void clickToCustomModificationsCollapse(WebDriver driver) {
        scrollToElement(driver, SellReviewPageUI.CUSTOM_MODIFICATIONS_COLLAPSE);
        waitForElementClickable(driver, SellReviewPageUI.CUSTOM_MODIFICATIONS_COLLAPSE);
        clickToElementByJS(driver, SellReviewPageUI.CUSTOM_MODIFICATIONS_COLLAPSE);
    }

    @Step("Verify that all added custom modifications = {1} are displayed")
    public boolean areAddedCustomModificationsDisplayed(WebDriver driver, String customModificationsText, List<String> customModifications) {
        boolean result = true;
        for(String customModification: customModifications) {
            waitForElementVisible(driver, SellReviewPageUI.CUSTOM_MODIFICATIONS_COLLAPSE_LIST_ITEMS, customModification);
            result = isElementDisplayed(driver, SellReviewPageUI.CUSTOM_MODIFICATIONS_COLLAPSE_LIST_ITEMS, customModification);
        }
        return result;
    }
}
