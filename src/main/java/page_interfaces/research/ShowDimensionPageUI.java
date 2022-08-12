package page_interfaces.research;

public interface ShowDimensionPageUI {
    String DIMENSION_TITLE_LABEL_H1 = "xpath=//h1[@class='title' and normalize-space(text()) = '%s']";
    String FOR_SALE_BUTTON = "xpath=//a[@class='linkBtn' and contains(text(), '%s')]";
    String DIMENSION_RESULT_TABLE_ROW = "css=div.content table tr.trBtn";
    String DIMENSION_RESULT_TABLE_DATA = "xpath=//tr[@class='trBtn']//a[text()='%s']//parent::td//following-sibling::td[contains(text(), '%s')]//following-sibling::td[contains(text(), '%s')]";
}
