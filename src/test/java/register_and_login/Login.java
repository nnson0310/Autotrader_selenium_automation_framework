package register_and_login;

import org.junit.jupiter.api.*;

@Tag("login")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Login {

    @BeforeAll
    public void setUp() {

    }

    @Test
    public void TC_01() {
        Assertions.assertEquals("123", "123");
    }
}
