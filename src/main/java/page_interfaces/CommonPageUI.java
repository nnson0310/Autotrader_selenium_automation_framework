package page_interfaces;

public interface CommonPageUI {
    String HEADER_LOGIN_BUTTON = "css=ul.header--navList-user div[data-cy='header-login-btn']";
    String AUTH_LOCK_SIGNUP_TAB = "xpath=//div[@class='auth0-lock-form']//a[text()='Sign Up']";
    String EMAIL_TEXTBOX = "css=input[name='email']";
    String PASSWORD_TEXTBOX = "css=input[name='password']";
    String FIRST_NAME_TEXTBOX = "css=input[name='first_name']";
    String LAST_NAME_TEXTBOX = "css=input[name='last_name']";
    String SIGNUP_BUTTON = "css=button[aria-label='Sign Up']";
    String USERNAME_HEADER_LABEL_DIV = "xpath=//ul[contains(@class, 'header--navList')]//div[@class='userName' and contains(text(), '%s')]";
    String LOGIN_BUTTON = "css=button[aria-label='Log In']";
    String VALIDATION_ERROR_LABEL_DIV = "xpath=//div[@role='alert']//div[text()='%s']";
    String LOGIN_ERROR_LABEL_SPAN = "xpath=//div[contains(@class, 'auth0-global-message')]//span[text()='%s']";
    String EDIT_PROFILE_HEADER_DROPDOWN_LINK = "xpath=//ul[contains(@class, 'header--navList')]//a[contains(text(), 'Edit Profile')]";
    String CREATE_MY_FREE_AD_BUTTON = "css=a.startAdBtn div";
    String DYNAMIC_TEXTBOX_BY_NAME_ATTRIBUTE = "xpath=//input[@name='%s']";
    String AUTOTRADER_LOGO = "css=div.header--banner svg.logo";
    String DYNAMIC_FOOTER_LINK = "xpath=//a[@class='footer--link' and contains(text(), '%s')]";
    String HEADER_NAV_SUB_ITEM_LINK = "xpath=//li[@class='header--navItem']//a[@class='header--navSubItem--link' and contains(text(), '%s')]";
    String HEADER_NAVIGATION_LINK = "xpath=//li[@class='header--navItem']//div[@class='header--navTopItem' and contains(text(), '%s')]";
    String SUCCESS_NOTIFICATION = "xpath=//div[contains(@class, 'success')]//p[contains(.,'%s')]";
    String FAVOURITED_CAR_HEADER_NAV_COUNT_LABEL_SPAN = "css=svg.shortlistIcon+div>span.header--navCount";
    String FAVOURITED_CAR_HEADER_NAV_COUNT_LABEL_DIV = "xpath=//*[name()='svg' and contains(@class, 'shortlistIcon')]//preceding-sibling::div";
    String SHORTLIST_CARD_ITEM = "xpath=//div[@class='shortlist--cards']//p[@class='title' and contains(text(), '%s')]//following-sibling::p[contains(text(), '%s')]";
    String SHORTLIST_SHOW_MORE_LINK = "css=div.header--shortlist p.shortlist--link";
}
