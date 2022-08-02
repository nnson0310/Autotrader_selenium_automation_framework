package commons;

import helpers.FunctionHelper;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GlobalConstants {
    private static GlobalConstants globalConstants;
    private GlobalConstants() {
    }

    public synchronized static GlobalConstants getGlobalConstants() {
        if (globalConstants == null) {
            return new GlobalConstants();
        }
        return globalConstants;
    }

    private String getPropertyValue(String fileName, String propertyName) {
        return FunctionHelper.readPropertiesFile(fileName).getProperty(propertyName);
    }

    // timeout for implicit wait and explicit wait
    private final long shortTimeout = 10;
    private final long longTimeout = 20;

    private final String projectPath = System.getProperty("user.dir");
    private final String osName = System.getProperty("os.name");
    private final String javaVersion = System.getProperty("java.version");

    private final String propertyFileName = "project.properties";
    private final String projectVersion = getPropertyValue(propertyFileName, "version");
    private final String projectName = getPropertyValue(propertyFileName, "name");
    private final String cloudUsername = getPropertyValue(propertyFileName, "cloud_username");
    private final String cloudAutomateKey = getPropertyValue(propertyFileName, "cloud_automate_key");

    private final String browserStackUrl = "https://" + cloudUsername + ":" + cloudAutomateKey + "@hub-cloud.browserstack.com/wd/hub";

}
