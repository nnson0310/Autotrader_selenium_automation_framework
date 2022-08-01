package commons;

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

    // timeout for implicit wait and explicit wait
    private final long shortTimeout = 10;
    private final long longTimeout = 20;

    private final String projectPath = System.getProperty("user.dir");
    private final String osName = System.getProperty("os.name");
    private final String javaVersion = System.getProperty("java.version");
}
