package parameter_resolver;

import data_resolver.Environment;
import helpers.FunctionHelper;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.util.Properties;

public class EnvironmentParameterResolver implements ParameterResolver {

    private final Properties properties = FunctionHelper.getEnvironmentProperties();

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == Environment.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return new Environment(
                properties.getProperty("url"),
                properties.getProperty("environment_name"),
                properties.getProperty("browser_name"),
                properties.getProperty("browser_version"),
                properties.getProperty("ip_address"),
                properties.getProperty("port"),
                properties.getProperty("os"),
                properties.getProperty("os_version")
        );
    }
}
