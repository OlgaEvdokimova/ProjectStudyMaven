package freeIt.hw18thread.task3.exceptions;

public class FileNotFoundExceptionOrOtherProblem extends RuntimeException {
    public FileNotFoundExceptionOrOtherProblem(String s) {
        super(s);
    }
}
