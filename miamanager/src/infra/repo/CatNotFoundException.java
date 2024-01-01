package infra.repo;

public class CatNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3476201083264436414L;

	public CatNotFoundException(String msg) {
		super(msg);
	}
}
