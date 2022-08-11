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
        for(String filter : selectedFilters) {
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
}
