package parameter_resolver;

import commons.GlobalConstants;
import data.Environment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentParameterResolver implements ParameterResolver {

    private final Properties properties = new Properties();

    private String getEnvironmentProperties(String propertyName) {
        BufferedInputStream bufferedInputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(GlobalConstants.getGlobalConstants().getPathToEnvironmentPropertyFile()));
            properties.load(bufferedInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties.getProperty(propertyName);
    }


    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == Environment.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return new Environment(
                getEnvironmentProperties("url"),
                getEnvironmentProperties("environment_name"),
                getEnvironmentProperties("browser_name"),
                getEnvironmentProperties("browser_version"),
                getEnvironmentProperties("ip_address"),
                getEnvironmentProperties("port"),
                getEnvironmentProperties("os"),
                getEnvironmentProperties("os_version")
        );
    }
}
