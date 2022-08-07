package helpers;

import com.github.javafaker.Faker;
import java.util.Random;

public class DataFaker {

    private static DataFaker dataFaker;

    private final Faker faker;

    private final String specialCharRegex = "[-+.^:,']";

    private DataFaker() {
        faker = new Faker();
    }

    public static DataFaker getDataFaker() {
        if (dataFaker == null) {
            return new DataFaker();
        }
        return dataFaker;
    }

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(99999);
    }

    public String generateEmail() {
        return "robert" + generateRandomNumber() + "@gmail.com";
    }

    public String generateFullName() {
        return faker.name().fullName().replaceAll(specialCharRegex, "");
    }

    public String generateFirstName() {
        return faker.name().firstName().replaceAll(specialCharRegex, "");
    }

    public String generateLastName() {
        return faker.name().lastName().replaceAll(specialCharRegex, "");
    }
}