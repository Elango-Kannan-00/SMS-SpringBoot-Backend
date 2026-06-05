package com.student_management.exception;

public class StudentException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public StudentException() {
        super();
    }

    public StudentException(String message) {
        super(message);
    }

    public StudentException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentException(Throwable cause) {
        super(cause);
    }
}
