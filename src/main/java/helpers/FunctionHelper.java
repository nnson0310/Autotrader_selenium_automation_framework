package helpers;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public final class FunctionHelper {

    private FunctionHelper() {

    }

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(9999);
    }

    public static void sleepInSeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getCurrentDay() {
        DateTime nowUTC = new DateTime(DateTimeZone.UTC);
        int day = nowUTC.getDayOfMonth();
        if (day < 10) {
            String dayValue = "0" + day;
            return dayValue;
        }
        return String.valueOf(day);
    }

    public static String getCurrentMonth() {
        DateTime now = new DateTime(DateTimeZone.UTC);
        int month = now.getMonthOfYear();
        if (month < 10) {
            String monthValue = "0" + month;
            return monthValue;
        }
        return String.valueOf(month);
    }

    public static String getCurrentYear() {
        DateTime now = new DateTime(DateTimeZone.UTC);
        return String.valueOf(now.getYear());
    }

    public static String getToday() {
        String today = getCurrentMonth() + "/" + getCurrentDay() + "/" + getCurrentYear();
        return today;
    }

    public static String getTodayByFormat(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    /**
     * Get width of product review rating element
     * @param cssStyleValue a string contains all of css style (ex: width: 80%; height: 70px;...)
     * @return width value of element (ex: 80% -> return 80)
     */
    public static int getProductReviewRatingByWidthValue(String cssStyleValue) {
        String cssStyleParts[] = cssStyleValue.split(";");
        String widthValue = "0";
        for(String cssStylePart : cssStyleParts) {
            cssStylePart.contains("width");
            widthValue = cssStylePart.replaceAll("[^0-9]", "");
        }
        return Integer.valueOf(widthValue);
    }

    public static String getProductPriceByText(String productPrice) {
        return productPrice.replace(".00", "").replaceAll("[$,]","");
    }

    public static String getOnlyCharacterFromString(String str) {
        return str.replaceAll("[^A-Za-z]+", "");
    }

    /**
     * Delete all files in specific folder
     * @param folder instance of File
     */
    public static void deleteAllFilesInFolder(File folder) {
        for(File file: folder.listFiles()) {
            if(!file.isDirectory()) {
                file.delete();
            }
        }
    }

    /**
     * Read content from pdf file
     * @param pathToFile relative path to pdf file
     * @return pdf content
     */
    public static String readPdfContent(String pathToFile) {
        String pdfText = null;
        try {
            File file = new File(pathToFile);
            FileInputStream fileInputStream = new FileInputStream(file);

            PDDocument pdfDocument = PDDocument.load(fileInputStream);
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            pdfText = pdfTextStripper.getText(pdfDocument);
            pdfDocument.close();
            return pdfText;
        } catch (IOException e) {
            System.out.println("Can not parse PDF content " + e.getMessage());
        }
        return pdfText;
    }

    public static byte[] getByteScreenshot(WebDriver driver) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(src);
        return fileContent;
    }
}
