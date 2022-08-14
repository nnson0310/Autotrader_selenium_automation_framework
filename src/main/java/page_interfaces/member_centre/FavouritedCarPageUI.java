package page_interfaces.member_centre;

public interface FavouritedCarPageUI {
    String ADDED_CAR_COUNT_LABEL_SPAN = "css=div.content span.count";
    String CAR_NAME_LABEL_P = "xpath=//div[@class='sListing--info']//p[contains(., '%s')]";
    String CAR_PRICE_LABEL_P = "xpath=//p[@class='priceAdvisor--price' and contains(text(), '%s')]";
    String CAR_ODOMETER_READING_LABEL_P = "xpath=//p[@class='spec' and contains(., '%s')]";
    String FAVOURITE_STAR_ICON = "css=div.sListing--btn";
}
