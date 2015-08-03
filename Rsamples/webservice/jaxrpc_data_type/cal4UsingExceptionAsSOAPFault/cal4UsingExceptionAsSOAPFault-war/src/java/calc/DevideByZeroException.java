package calc;

public class DevideByZeroException extends Exception {

    private String errorMsg;

    public DevideByZeroException() {

    }

    public DevideByZeroException(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
