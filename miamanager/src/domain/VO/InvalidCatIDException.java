package domain.VO;

public class InvalidCatIDException extends RuntimeException {

	private static final long serialVersionUID = 1579024493697795440L;

	public InvalidCatIDException(String msg) {
		super(msg);
	}

}
