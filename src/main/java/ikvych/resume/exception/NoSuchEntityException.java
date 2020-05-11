package ikvych.resume.exception;

public class NoSuchEntityException extends RuntimeException{

    public NoSuchEntityException() {
    }

    public NoSuchEntityException(String s) {
        super(s);
    }

    public NoSuchEntityException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NoSuchEntityException(Throwable throwable) {
        super(throwable);
    }

    public NoSuchEntityException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
