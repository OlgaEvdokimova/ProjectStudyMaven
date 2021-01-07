package hw18thread.task3.exceptions;

public class WrongEmailException extends RuntimeException {
    public WrongEmailException(String s) {
        super(s);
    }
}
