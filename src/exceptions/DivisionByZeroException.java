package exceptions;

/**
 * This exception is thrown in cases where the second parameter is 0 in the division operation.
 * @author AleksandarKekic
 * @version 1.0
 * @since 2023-02-01
 * 
 */
public class DivisionByZeroException extends Exception {
	
	
	/**
	 * This is a constructor without parameters.
	 */
	public  DivisionByZeroException() {super();}
	
	
	
	/**
	 * This is a constructor with a message.
	 * @param message The message that will be displayed when this exception is thrown.
	 */
	public  DivisionByZeroException(String message) {super(message);}

}
