package sample.Exceptions;

public class HourlyrateTooLowException extends RateException {
    public HourlyrateTooLowException(String message) {
        super(message);
    }
}
