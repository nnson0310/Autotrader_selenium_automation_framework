package page_interfaces.for_sale;

public interface ForSalePageUI {
    String SEARCH_TITLE_LABEL_H1 = "xpath=//h1[contains(@class, 'search--title') and contains(text(), '%s')]";
    String SELECTED_FILTER_LABEL_P = "xpath=//div[contains(@class, 'headFilters--pill')]//p[text()='%s']";
    String CAR_LISTING_TITLE_LABEL_STRONG = "xpath=//h3[@class='carListing--title']//strong[contains(text(), '%s')]";
    String SHORTLIST_HEART_ICON = "xpath=//h3[contains(., '%s')]//ancestor::div[@class='cardLayout']//div[contains(@class, 'carListing--shortlistHeart')]//button";
    String MAKE_FILTER_LINK = "xpath=//div[@class='mmvs--popular']//a[contains(text(), '%s')]";
    String FILTER_LINK = "xpath=//div[@data-cy='%s']//a[contains(text(), '%s')]";
    String LOADING_ICON = "css=div.loader--container";
    String CAR_NAME_LABEL_H3 = "css=h3.carListing--title";
    String CAR_PRICE_LABEL_SPAN = "css=span.carListingPrice--advertisedPrice";
}
