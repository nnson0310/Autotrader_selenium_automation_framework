package parameter_test_data;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class LoginCredentials {

    public static Stream<Arguments> invalidEmail() {
        return Stream.of(
                Arguments.of("david@gmail", "123456", "Email is invalid"),
                Arguments.of("davidgmail.com", "123456", "Email is invalid"),
                Arguments.of("david@", "123456", "Email is invalid")
        );
    }

    public static Stream<Arguments> invalidPassword() {
        return Stream.of(
                Arguments.of("Zutan@gmail.com", "Robert1234", "Wrong email or password."),
                Arguments.of("Satan@gmail.com", "123456", "Wrong email or password."),
                Arguments.of("Sanhunadxx@gmail.com", "$#@!&^123", "Wrong email or password.")
        );
    }
}
