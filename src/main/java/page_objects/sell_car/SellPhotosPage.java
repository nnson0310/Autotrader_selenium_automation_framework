package page_objects.sell_car;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page_interfaces.sell_car.SellPhotosPageUI;
import page_objects.CommonPage;
import page_objects.PageInitManager;

public class SellPhotosPage extends CommonPage {
    WebDriver driver;

    public SellPhotosPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Upload photos with url = {1}")
    public void uploadPhotos(WebDriver driver, String uploadPhotos) {
        waitForPresentOfElement(driver, SellPhotosPageUI.UPLOAD_PHOTOS_INPUT);
        sendKeyToUploadFile(driver, SellPhotosPageUI.UPLOAD_PHOTOS_INPUT, uploadPhotos);
    }

    @Step("Verify that all photos are uploaded successfully")
    public boolean areAllPhotosUploaded(WebDriver driver) {
        waitForElementInvisible(driver, SellPhotosPageUI.UPLOADING_ICON);
        return areAllImagesUploaded(driver, SellPhotosPageUI.UPLOAD_IMAGE);
    }

    @Step("Click to 'Save and Continue' button")
    public SellFeaturesPage clickToSaveAndContinueButton(WebDriver driver) {
        waitForElementClickable(driver, SellPhotosPageUI.SAVE_AND_CONTINUE_BUTTON);
        clickToElement(driver, SellPhotosPageUI.SAVE_AND_CONTINUE_BUTTON);
        return PageInitManager.getPageInitManager().getSellFeaturesPage(driver);
    }
}
