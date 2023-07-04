package FivvyChallenge.Backend.Exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5363126647489839134L;

	public NotFoundException(String message) {
		super(message);
	}
}
