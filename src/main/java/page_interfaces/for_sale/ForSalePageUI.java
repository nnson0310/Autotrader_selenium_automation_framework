package page_interfaces.for_sale;

public interface ForSalePageUI {
    String SEARCH_TITLE_LABEL_H1 = "xpath=//h1[contains(@class, 'search--title') and contains(text(), '%s')]";
    String SELECTED_FILTER_LABEL_P = "xpath=//div[contains(@class, 'headFilters--pill')]//p[text()='%s']";
    String CAR_LISTING_TITLE_LABEL_STRONG = "xpath=//h3[@class='carListing--title']//strong[contains(text(), '%s')]";
}
