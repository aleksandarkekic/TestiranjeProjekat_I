package calculators;
import exceptions.DivisionByZeroException;
import exceptions.NotSupportedOperationException;

/**
 *This class is used for simple mathematical operations such as addition,
 * subtraction, multiplication, and division.
 * @author AleksandarKekic
 * @version 1.0
 * @since 2023-02-01
 *
 */
public class Calculator {
	
	private Double currentValue;
	
	
	/**
	 * This is default constructor.
	 * In the body of this constuctor we are setting the field currentValue to the initial value which is 0.
	 */
	public Calculator() {this.currentValue=(double) 0;}
	
	
	
	/**
	 * This is a classic get method.
	 * @return This method returns currentValue.
	 */
	public Double getCurrentValue() {return currentValue;}
	
	
	
	/**
	 * This is the classic set method.
	 * @param currentValue This is the only parameter of the method and its value is assigned to the currentValue.
	 */
	public void setCurrentValue(Double currentValue) {this.currentValue = currentValue;}
	
	
	
	/**
	 * This method enables the execution of mathematical operations.
	 * The following mathematical operations are supported:
	 * addition(+), subtraction(-), multiplication(*), and division(/).
	 * @param value This is the first parameter.There is multiple options for this parameter.
	 * In case that operation is addition, its value is going to be added to the value to the currentValue.
	 * In case that operation is subtraction, its value is going to be subtracted from the currentValue.
	 * In case that operation is multiplication, its value is going to be multiplied by the currentValue.
	 * In case that operation is division, its value is going to be divided by the currentValue.
	 * @param operator This is the second parameter and represents mathematical operation.
	 * @throws DivisionByZeroException This method will throw this exception if the value of the first parameter is 0.
	 * @throws NotSupportedOperationException This method will throw this exception the parameter operator is not supported.
	 */
	public void calculate(Double value, char operator) throws Exception {
		switch(operator) {
		case '+':
			currentValue+=value;
			break;
		case '-':
			currentValue-=value;
			break;
		case '*':
			currentValue*=value;
			break;
		case'/':
			if(value.equals(Double.valueOf(0))) {
				throw new DivisionByZeroException("Division by zero exception");
			}else {
				currentValue/=value;
			}
			break;
		default:
			throw new NotSupportedOperationException("Not supported operation exception");
		}
	}
	
	

}
