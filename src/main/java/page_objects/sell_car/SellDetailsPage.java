package page_objects.sell_car;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page_interfaces.sell_car.SellDetailsPageUI;
import page_objects.CommonPage;
import page_objects.PageInitManager;

public class SellDetailsPage extends CommonPage {
    WebDriver driver;

    public SellDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Verify that car name = {1} is displayed correctly")
    public boolean isCarNameDisplayed(WebDriver driver, String carName) {
        waitForElementVisible(driver, SellDetailsPageUI.VEHICLE_CONTENT_LABEL_DIV, carName);
        return isElementDisplayed(driver, SellDetailsPageUI.VEHICLE_CONTENT_LABEL_DIV, carName);
    }

    @Step("Verify that car transmission = {1} is displayed correctly")
    public boolean isCarTransmissionDisplayed(WebDriver driver, String transmission) {
        waitForElementVisible(driver, SellDetailsPageUI.CAR_TRANSMISSION_LABEL_SPAN, transmission);
        return getElementText(driver, SellDetailsPageUI.CAR_TRANSMISSION_LABEL_SPAN, transmission).contains(transmission);
    }

    @Step("Verify that car year = {1} is displayed correctly")
    public boolean isCarYearDisplayed(WebDriver driver, String year) {
        waitForElementVisible(driver, SellDetailsPageUI.CAR_YEAR_LABEL_SPAN, year);
        return getElementText(driver, SellDetailsPageUI.CAR_YEAR_LABEL_SPAN, year).contains(year);
    }

    @Step("Verify that car body type = {1} is displayed correctly")
    public boolean isCarBodyTypeDisplayed(WebDriver driver, String bodyType) {
        waitForElementVisible(driver, SellDetailsPageUI.CAR_BODY_TYPE_LABEL_SPAN, bodyType);
        return getElementText(driver, SellDetailsPageUI.CAR_BODY_TYPE_LABEL_SPAN, bodyType).contains(bodyType);
    }

    @Step("Verify that car fuel type = {1} is displayed correctly")
    public boolean isCarFuelTypeDisplayed(WebDriver driver, String fuelType) {
        waitForElementVisible(driver, SellDetailsPageUI.CAR_FUEL_TYPE_LABEL_SPAN, fuelType);
        return getElementText(driver, SellDetailsPageUI.CAR_FUEL_TYPE_LABEL_SPAN, fuelType).contains(fuelType);
    }

    @Step("Select car pickup location = {1}")
    public void selectToCarPickupLocationDropdown(WebDriver driver, String pickupLocationInput, String pickupLocationSelect) {
        waitForElementVisible(driver, SellDetailsPageUI.PICKUP_LOCATION_TEXTBOX);
        sendKeyToElement(driver, SellDetailsPageUI.PICKUP_LOCATION_TEXTBOX, pickupLocationInput);

        waitForElementClickable(driver, SellDetailsPageUI.PICKUP_LOCATION_SELECT_ITEM, pickupLocationSelect);
        clickToElement(driver, SellDetailsPageUI.PICKUP_LOCATION_SELECT_ITEM, pickupLocationSelect);
    }

    @Step("Check to registration_expired radio = {1}")
    public void checkToRegistrationExpiredRadio(WebDriver driver, String expired) {
        waitForElementClickable(driver, SellDetailsPageUI.REGISTRATION_EXPIRED_RADIO, expired);
        clickToElement(driver, SellDetailsPageUI.REGISTRATION_EXPIRED_RADIO, expired);
    }

    @Step("Check to come_with_logbook radio = {1}")
    public void checkToLogbookRadio(WebDriver driver, String logbook) {
        waitForElementClickable(driver, SellDetailsPageUI.COME_WITH_LOGBOOK_RADIO, logbook);
        clickToElement(driver, SellDetailsPageUI.COME_WITH_LOGBOOK_RADIO, logbook);
    }

    @Step("Select sets of keys = {1}")
    public void selectToSetOfKeysDropdown(WebDriver driver, String setKeys) {
        waitForElementClickable(driver, SellDetailsPageUI.SET_OF_KEYS_SELECT_DROPDOWN);
        clickToElement(driver, SellDetailsPageUI.SET_OF_KEYS_SELECT_DROPDOWN);

        waitForElementClickable(driver, SellDetailsPageUI.SET_OF_KEYS_SELECT_ITEM, setKeys);
        clickToElement(driver, SellDetailsPageUI.SET_OF_KEYS_SELECT_ITEM, setKeys);
    }

    @Step("Select expiry month = {1}")
    public void selectToExpiryMonthDropdown(WebDriver driver, String month) {
        waitForElementClickable(driver, SellDetailsPageUI.EXPIRY_MONTH_SELECT_DROPDOWN);
        clickToElement(driver, SellDetailsPageUI.EXPIRY_MONTH_SELECT_DROPDOWN);

        waitForElementClickable(driver, SellDetailsPageUI.EXPIRY_MONTH_SELECT_ITEM, month);
        scrollToElement(driver, SellDetailsPageUI.EXPIRY_MONTH_SELECT_ITEM, month);
        clickToElement(driver, SellDetailsPageUI.EXPIRY_MONTH_SELECT_ITEM, month);
    }

    @Step("Select expiry year = {1}")
    public void selectToExpiryYearDropdown(WebDriver driver, String year) {
        waitForElementClickable(driver, SellDetailsPageUI.EXPIRY_YEAR_SELECT_DROPDOWN);
        clickToElement(driver, SellDetailsPageUI.EXPIRY_YEAR_SELECT_DROPDOWN);

        waitForElementClickable(driver, SellDetailsPageUI.EXPIRY_YEAR_SELECT_ITEM, year);
        scrollToElement(driver, SellDetailsPageUI.EXPIRY_YEAR_SELECT_ITEM, year);
        clickToElement(driver, SellDetailsPageUI.EXPIRY_YEAR_SELECT_ITEM, year);
    }

    @Step("Click to 'Save And Continue' button")
    public SellPhotosPage clickToSaveAndContinueButton(WebDriver driver) {
        waitForElementClickable(driver, SellDetailsPageUI.SAVE_AND_CONTINUE_BUTTON);
        clickToElement(driver, SellDetailsPageUI.SAVE_AND_CONTINUE_BUTTON);
        return PageInitManager.getPageInitManager().getSellPhotosPage(driver);
    }
}
