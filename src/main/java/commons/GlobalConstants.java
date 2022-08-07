package commons;

import helpers.FunctionHelper;
import lombok.Getter;
import lombok.Setter;
import java.io.File;
import java.nio.file.Paths;

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

    private final String pathLogFile = projectPath + File.separator + "log4j2" + File.separator + "app.log";
    private final String pathToRecordVideo = projectPath + File.separator + "record-videos";
    private final String pathToMainResource =  Paths.get("src", "main", "resources").toFile().getAbsolutePath();
    private final String pathToTestResource = Paths.get("src", "test", "resources").toFile().getAbsolutePath();
    private final String pathToEnvironmentPropertyFile = pathToMainResource + File.separator + "environment.properties";
    private final String pathToBrowserStackVideo = projectPath + File.separator + "browser-stack-videos" + File.separator;

    private final String projectPropertyFileName = "project.properties";
    private final String projectVersion = getPropertyValue(projectPropertyFileName, "version");
    private final String projectName = getPropertyValue(projectPropertyFileName, "name");
    private final String cloudUsername = getPropertyValue(projectPropertyFileName, "cloud_username");
    private final String cloudAutomateKey = getPropertyValue(projectPropertyFileName, "cloud_automate_key");

    private final String browserStackUrl = "https://" + cloudUsername + ":" + cloudAutomateKey + "@hub-cloud.browserstack.com/wd/hub";

}
