package register_and_login;

import org.junit.jupiter.api.*;

@Tag("demo")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Demo {

    @BeforeAll
    public void beforeAll() {
        System.out.println("I am Before All");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("I am Before Each");
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
        System.out.println("I am After All");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("I am After Each");
    }

}
