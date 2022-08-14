package page_objects.member_centre;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page_interfaces.member_centre.MemberCentrePageUI;
import page_objects.CommonPage;

public class MemberCentrePage extends CommonPage {

    @Step("In Member Centre Page, click to sidebar menu = {1}")
    public void clickToSidebarMenu(WebDriver driver, String sidebarMenu) {
        waitForElementClickable(driver, MemberCentrePageUI.SIDEBAR_MENU_ITEM_LINK, sidebarMenu);
        clickToElement(driver, MemberCentrePageUI.SIDEBAR_MENU_ITEM_LINK, sidebarMenu);
    }
}
