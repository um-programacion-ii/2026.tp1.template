package com.bibliotech.exception;

public class MemberLimitExceededException extends LibraryException {
    public MemberLimitExceededException(String message) {
        super(message);
    }
}
