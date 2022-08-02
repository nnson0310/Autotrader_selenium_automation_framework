package register_and_login;

import commons.BaseTest;
import data.Environment;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import parameter_resolver.EnvironmentParameterResolver;

@Tag("demo")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(EnvironmentParameterResolver.class)
public class Demo extends BaseTest {

    WebDriver driver;

    @BeforeAll
    public void beforeAll(Environment environment) {
        driver = getBrowserDriver(
                environment.getUrl(),
                environment.getEnvironmentName(),
                environment.getBrowserName(),
                environment.getBrowserVersion(),
                environment.getIpAddress(),
                environment.getPort(),
                environment.getOs(),
                environment.getOsVersion()
        );
    }

    @Test
    public void TC_01() {
        Assertions.assertEquals("123", "123");
    }

    @Test
    public void TC_02() {
        Assertions.assertEquals("567", "567");
    }


    @AfterAll
    public void afterAll() {
        closeBrowserAndKillProcess();
    }

}
