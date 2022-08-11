package page_objects.sell_car;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page_interfaces.sell_car.SellDescriptionPageUI;
import page_objects.CommonPage;
import page_objects.PageInitManager;

public class SellDescriptionPage extends CommonPage {
    WebDriver driver;

    public SellDescriptionPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter to description textarea = {1}")
    public void enterToDescriptionTextarea(WebDriver driver, String description) {
        waitForElementVisible(driver, SellDescriptionPageUI.DESCRIPTION_TEXTAREA);
        sendKeyToElement(driver, SellDescriptionPageUI.DESCRIPTION_TEXTAREA, description);
    }

    @Step("Click to 'Save And Continue' and redirect to Review Page")
    public SellReviewPage clickToSaveAndContinueButton(WebDriver driver) {
        waitForElementClickable(driver, SellDescriptionPageUI.SAVE_AND_CONTINUE_BUTTON);
        clickToElement(driver, SellDescriptionPageUI.SAVE_AND_CONTINUE_BUTTON);
        return PageInitManager.getPageInitManager().getSellReviewPage(driver);
    }
}
