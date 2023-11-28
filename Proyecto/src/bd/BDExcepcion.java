package bd;

public class BDExcepcion extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BDExcepcion(String message) {
		super(message);
	}
	
	public BDExcepcion(String message, Throwable e) {
		super(message, e);
	}
}