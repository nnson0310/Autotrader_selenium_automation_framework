package parameter_test_data;

import helpers.DataFaker;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class ContactUs implements ArgumentsProvider {

    private final DataFaker dataFaker = DataFaker.getDataFaker();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(
                        "Website issue, suggestion or comment",
                        dataFaker.generateFullName(),
                        dataFaker.generateEmail(),
                        dataFaker.generateLoremIpsum(),
                        "Your enquiry was submitted successfully. We will get back to you as soon as possible."
                )
        );
    }
}
