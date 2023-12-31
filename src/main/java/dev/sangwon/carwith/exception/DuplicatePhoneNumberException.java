package dev.sangwon.carwith.exception;

public class DuplicatePhoneNumberException extends RuntimeException{
    public DuplicatePhoneNumberException(String message){
        super(message);
    }
}
