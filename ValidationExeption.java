public class ValidationExeption extends Exception {

    private String message;

    public ValidationExeption(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
