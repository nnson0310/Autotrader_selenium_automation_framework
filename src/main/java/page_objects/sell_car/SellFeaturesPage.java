package page_objects.sell_car;

import helpers.FunctionHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page_interfaces.sell_car.SellFeaturesPageUI;
import page_objects.CommonPage;
import page_objects.PageInitManager;

import java.util.List;

public class SellFeaturesPage extends CommonPage {
    WebDriver driver;

    public SellFeaturesPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to toggle 'Optional Extras'")
    public void clickToOptionalExtrasCollapse(WebDriver driver) {
        waitForElementClickable(driver, SellFeaturesPageUI.OPTIONAL_EXTRAS_COLLAPSE);
        clickToElement(driver, SellFeaturesPageUI.OPTIONAL_EXTRAS_COLLAPSE);
    }

    @Step("Click to toggle 'Custom Modifications'")
    public void clickToCustomModificationsCollapse(WebDriver driver) {
        waitForElementClickable(driver, SellFeaturesPageUI.CUSTOM_MODIFICATIONS_COLLAPSE);
        clickToElement(driver, SellFeaturesPageUI.CUSTOM_MODIFICATIONS_COLLAPSE);
    }

    @Step("Click to radio button to choose optional extras = {1}")
    public void clickToOptionalExtrasRadioButton(WebDriver driver, String optionalExtrasText, List<String> optionalExtras) {
        for(String optionalExtra: optionalExtras) {
            waitForElementClickable(driver, SellFeaturesPageUI.OPTIONAL_EXTRAS_RADIO_BUTTON, optionalExtra);
            clickToElement(driver, SellFeaturesPageUI.OPTIONAL_EXTRAS_RADIO_BUTTON, optionalExtra);
        }
    }

    @Step("Add custom modifications = {1}")
    public void addCustomModifications(WebDriver driver, String customModificationsText, List<String> customModifications) {
        waitForElementVisible(driver, SellFeaturesPageUI.CUSTOM_MODIFICATIONS_TEXTBOX);
        waitForElementClickable(driver, SellFeaturesPageUI.ADD_CUSTOM_MODIFICATIONS_BUTTON);

        for(String customModification: customModifications) {
            sendKeyToElement(driver, SellFeaturesPageUI.CUSTOM_MODIFICATIONS_TEXTBOX, customModification);
            clickToElement(driver, SellFeaturesPageUI.ADD_CUSTOM_MODIFICATIONS_BUTTON);
        }
    }

    @Step("Click to 'Save And Continue' button")
    public SellDescriptionPage clickToSaveAndContinueButton(WebDriver driver) {
        waitForElementVisible(driver, SellFeaturesPageUI.SAVE_AND_CONTINUE_BUTTON);
        clickToElement(driver, SellFeaturesPageUI.SAVE_AND_CONTINUE_BUTTON);
        return PageInitManager.getPageInitManager().getSellDescriptionPage(driver);
    }

    @Step("Get step indicator of checked optional extras = {1}")
    public int getCheckedOptionalExtras(WebDriver driver, int numberOfOptionalExtras) {
        waitForElementVisible(driver, SellFeaturesPageUI.OPTIONAL_EXTRAS_STEP_INDICATOR_LABEL_P);
        return FunctionHelper.getStepIndicator(getElementText(driver, SellFeaturesPageUI.OPTIONAL_EXTRAS_STEP_INDICATOR_LABEL_P).trim());
    }

    @Step("Get step indicator of custom modification = {1}")
    public int getAddedCustomModifications(WebDriver driver, int numberOfCustomModifications) {
        waitForElementVisible(driver, SellFeaturesPageUI.CUSTOM_MODIFICATIONS_STEP_INDICATOR_LABEL_P);
        return FunctionHelper.getStepIndicator(getElementText(driver, SellFeaturesPageUI.CUSTOM_MODIFICATIONS_STEP_INDICATOR_LABEL_P).trim());
    }
}
