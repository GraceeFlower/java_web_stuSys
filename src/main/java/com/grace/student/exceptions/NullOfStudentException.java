package com.grace.student.exceptions;

public class NullOfStudentException extends RuntimeException {

    public NullOfStudentException() {
    }

    public NullOfStudentException(String message) {
        super(message);
    }

    public NullOfStudentException(String message, Throwable cause) {
        super(message, cause);
    }
}
