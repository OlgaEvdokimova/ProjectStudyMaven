package freeIt.hw18thread.task3.exceptions;

public class EmptyFileException extends RuntimeException {
    public EmptyFileException(String file_is_empty) {
        super(file_is_empty);
    }
}
