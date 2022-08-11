package page_interfaces.home;

public interface HomePageUI {

    String MAKE_SEARCH_TEXTBOX = "xpath=//input[contains(@class, 'searchInput') and @placeholder='Make']";
    String MEGA_DROPDOWN_ITEM = "xpath=//div[@class='megaDropdown']//span[text()='%s']";
    String MODEL_SEARCH_TEXTBOX = "xpath=//input[contains(@class, 'searchInput') and @placeholder='Model']";
}
