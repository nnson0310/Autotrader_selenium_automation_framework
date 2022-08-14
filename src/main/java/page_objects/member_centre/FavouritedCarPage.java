package page_objects.member_centre;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page_interfaces.CommonPageUI;
import page_interfaces.member_centre.FavouritedCarPageUI;

import java.util.List;

public class FavouritedCarPage extends MemberCentrePage {
    WebDriver driver;

    public FavouritedCarPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get counter of added favourite car")
    public int getAddedCarCount(WebDriver driver) {
        waitForElementVisible(driver, FavouritedCarPageUI.ADDED_CAR_COUNT_LABEL_SPAN);
        return Integer.parseInt(getElementText(driver, FavouritedCarPageUI.ADDED_CAR_COUNT_LABEL_SPAN).replaceAll("[^0-9]",""));
    }

    @Step("Verify that car name = {1}")
    public boolean isCarNameDisplayed(WebDriver driver, String name) {
        waitForElementVisible(driver, FavouritedCarPageUI.CAR_NAME_LABEL_P, name);
        return isElementDisplayed(driver, FavouritedCarPageUI.CAR_NAME_LABEL_P, name);
    }

    @Step("Verify that price advisor = {1}")
    public boolean isPriceDisplayed(WebDriver driver, String price) {
        waitForElementVisible(driver, FavouritedCarPageUI.CAR_PRICE_LABEL_P, price);
        return isElementDisplayed(driver, FavouritedCarPageUI.CAR_PRICE_LABEL_P, price);
    }

    @Step("Verify that odometer reading = {1}")
    public boolean isOdometerReadingDisplayed(WebDriver driver, String odometerReading) {
        waitForElementVisible(driver, FavouritedCarPageUI.CAR_ODOMETER_READING_LABEL_P, odometerReading);
        return isElementDisplayed(driver, FavouritedCarPageUI.CAR_ODOMETER_READING_LABEL_P, odometerReading);
    }

    @Step("Click to all star icon to remove all added car in shortlist")
    public void clickToStarIconToRemoveAllCars(WebDriver driver) {
        List<WebElement> starIcons = getElements(driver, FavouritedCarPageUI.FAVOURITE_STAR_ICON);
        System.out.println(starIcons.size());
        if (starIcons.size() > 0) {
            waitForAllElementVisible(driver, FavouritedCarPageUI.FAVOURITE_STAR_ICON);
            for(WebElement starIcon: starIcons) {
                clickToElement(driver, FavouritedCarPageUI.FAVOURITE_STAR_ICON);
                waitForStalenessOfElement(driver, CommonPageUI.SUCCESS_NOTIFICATION, "You have removed a car from your shortlist.");
            }
        }
    }
}
