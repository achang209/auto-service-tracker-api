package com.example.autoservicetrackerapi.exception;

public class StorageException extends RuntimeException {
    private static final long serialVersionUID = 6366453013044211665L;

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
