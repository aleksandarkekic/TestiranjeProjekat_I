package exceptions;

/**
 * This exception is thrown in cases where the operation is invalid.
 * @author AleksandarKekic
 * @version 1.0
 * @since 2023-02-01
 */
public class NotSupportedOperationException extends Exception{
	
	
	/**
	 * This is a constructor without parameters.
	 */
	public NotSupportedOperationException() {super();}
	
	
	
	/**
	 * This is a constructor with a message.
	 * @param message The message that will be displayed when this exception is thrown.
	 */
	public NotSupportedOperationException(String message) {super(message);}


}
