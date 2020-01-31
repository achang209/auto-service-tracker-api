package com.example.autoservicetrackerapi.exception;

public class StorageFileNotFoundException extends StorageException {

    private static final long serialVersionUID = 6873613153457043228L;

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
