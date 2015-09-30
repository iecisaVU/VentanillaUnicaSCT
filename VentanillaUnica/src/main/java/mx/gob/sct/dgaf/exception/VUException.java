package mx.gob.sct.dgaf.exception;

public class VUException extends Exception {

	private static final long serialVersionUID = -2643208119688178988L;

	public VUException(String message) {
		super(message);
	}

	public VUException(Throwable causa) {
		super(causa);
	}

	public VUException(String message, Throwable causa) {
		super(message, causa);
	}
}
