package com.updated.rollTheDice.Exceptions;

import java.io.IOException;

public class JsonFileLoadException extends IOException {
    public JsonFileLoadException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonFileLoadException(String message) {
        super(message);
    }
}
