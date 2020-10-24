package sample.Exceptions;

public class CourseRateTooLowException extends RateException {
    public CourseRateTooLowException(String message) {
        super(message);
    }
}
