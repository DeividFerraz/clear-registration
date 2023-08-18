package project.client.client.services.exceptions;

public class DuplicateCpfException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMessage;

    public DuplicateCpfException(String message, String errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

