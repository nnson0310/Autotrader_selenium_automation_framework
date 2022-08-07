package custom_exceptions;

import commons.GlobalConstants;

public class InvalidBuildException extends RuntimeException {

    public InvalidBuildException(String message) {
        super(message);
    }
}
