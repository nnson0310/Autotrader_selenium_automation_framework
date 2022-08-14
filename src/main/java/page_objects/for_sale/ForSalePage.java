package page_objects.for_sale;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page_interfaces.for_sale.ForSalePageUI;
import page_objects.CommonPage;

import java.util.List;

public class ForSalePage extends CommonPage {
    WebDriver driver;

    public ForSalePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Verify that search title contains {1}")
    public boolean isSearchTitleDisplayed(WebDriver driver, String carName) {
        waitForElementVisible(driver, ForSalePageUI.SEARCH_TITLE_LABEL_H1, carName);
        return isElementDisplayed(driver, ForSalePageUI.SEARCH_TITLE_LABEL_H1, carName);
    }

    @Step("Verify all selected filters are displayed correctly")
    public boolean areSelectedFiltersDisplayed(WebDriver driver, List<String> selectedFilters) {
        boolean result = true;
        for (String filter : selectedFilters) {
            waitForElementVisible(driver, ForSalePageUI.SELECTED_FILTER_LABEL_P, filter);
            result = isElementDisplayed(driver, ForSalePageUI.SELECTED_FILTER_LABEL_P, filter);
        }
        return result;
    }

    @Step("Get number of car listing title contains {1} to validate")
    public String getNumberOfCarListingTitle(WebDriver driver, String carName) {
        waitForElementVisible(driver, ForSalePageUI.CAR_LISTING_TITLE_LABEL_STRONG, carName);
        return String.valueOf(getElementSize(driver, ForSalePageUI.CAR_LISTING_TITLE_LABEL_STRONG, carName));
    }

    @Step("Click to heart icon of car name = {1} to add car to favourite list")
    public void clickToShortListHeartIcon(WebDriver driver, String carName) {
        waitForElementClickable(driver, ForSalePageUI.SHORTLIST_HEART_ICON, carName);
        clickToElement(driver, ForSalePageUI.SHORTLIST_HEART_ICON, carName);
    }

    @Step("Click to filter link = {1}")
    public void clickToFilterLink(WebDriver driver, String mainFilterLink, String subFilterLink) {
        waitForElementInvisible(driver, ForSalePageUI.LOADING_ICON);
        waitForElementClickable(driver, ForSalePageUI.FILTER_LINK, mainFilterLink, subFilterLink);
        clickToElement(driver, ForSalePageUI.FILTER_LINK, mainFilterLink, subFilterLink);
    }

    @Step("Verify that all filtered cars name contain '{1}'")
    public boolean isCarNameDisplayed(WebDriver driver, String carName) {
        boolean result = true;
        waitForAllElementVisible(driver, ForSalePageUI.CAR_NAME_LABEL_H3);
        List<String> names = getElementsText(driver, ForSalePageUI.CAR_NAME_LABEL_H3);
        for(String name: names) {
            result = name.contains(carName);
        }
        return result;
    }

    @Step("Get number of filtered cars")
    public int getNumberOfCars(WebDriver driver) {
        waitForAllElementVisible(driver, ForSalePageUI.CAR_NAME_LABEL_H3);
        return getElementSize(driver, ForSalePageUI.CAR_NAME_LABEL_H3);
    }

    @Step("Verify that all filtered car price are below {2}")
    public boolean isCarPriceDisplayed(WebDriver driver, String carPrice) {
        boolean result = true;
        waitForAllElementVisible(driver, ForSalePageUI.CAR_PRICE_LABEL_SPAN);
        List<String> prices = getElementsText(driver, ForSalePageUI.CAR_PRICE_LABEL_SPAN);
        for(String price: prices) {
            result = price.equalsIgnoreCase(carPrice);
        }
        return result;
    }
}
