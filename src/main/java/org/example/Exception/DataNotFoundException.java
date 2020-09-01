package org.example.Exception;

public class DataNotFoundException extends RuntimeException {
    private static final long SerialVersionID = 7326478236784623L;

    public DataNotFoundException(String message) {
        super(message);
    }
}
