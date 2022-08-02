package data;

import lombok.Getter;

@Getter
public class Environment {

    private final String url;
    private final String browserName;
    private final String browserVersion;
    private final String environmentName;
    private final String ipAddress;
    private final String port;
    private final String os;
    private final String osVersion;

    public Environment(
            String url,
            String environmentName,
            String browserName,
            String browserVersion,
            String ipAddress,
            String port,
            String os,
            String osVersion
    ) {
        this.url = url;
        this.environmentName = environmentName;
        this.browserName = browserName;
        this.browserVersion = browserVersion;
        this.ipAddress = ipAddress;
        this.port = port;
        this.os = os;
        this.osVersion = osVersion;
    }
}
