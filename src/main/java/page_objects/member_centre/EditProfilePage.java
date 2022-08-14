package page_objects.member_centre;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page_interfaces.member_centre.EditProfilePageUI;

public class EditProfilePage extends MemberCentrePage {
    WebDriver driver;

    public EditProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter to first_name textbox of edit_profile form with first_name = {1}")
    public void enterToFirstNameTextbox(WebDriver driver, String firstName) {
        waitForElementVisible(driver, EditProfilePageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, EditProfilePageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    @Step("Enter to last_name textbox of edit_profile form with last_name = {1}")
    public void enterToLastNameTextbox(WebDriver driver, String lastName) {
        waitForElementVisible(driver, EditProfilePageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, EditProfilePageUI.LAST_NAME_TEXTBOX, lastName);
    }

    @Step("Click to Save button in edit_profile form")
    public void clickToSaveButton(WebDriver driver) {
        waitForElementClickable(driver, EditProfilePageUI.SAVE_BUTTON);
        clickToElement(driver, EditProfilePageUI.SAVE_BUTTON);
    }

    @Step("Click to Save_Changes button of modal")
    public void clickToSaveChangesModalButton(WebDriver driver) {
        waitForElementClickable(driver, EditProfilePageUI.SAVE_CHANGES_MODAL_BUTTON);
        clickToElement(driver, EditProfilePageUI.SAVE_CHANGES_MODAL_BUTTON);
    }

    @Step("Verify that success notification = {1} is displayed")
    public boolean isChangeSuccessNotifyDisplayed(WebDriver driver, String successNotify) {
        waitForElementVisible(driver, EditProfilePageUI.CHANGE_SUCCESS_NOTIFICATION_LABEL_DIV, successNotify);
        return isElementDisplayed(driver, EditProfilePageUI.CHANGE_SUCCESS_NOTIFICATION_LABEL_DIV, successNotify);
    }
}
