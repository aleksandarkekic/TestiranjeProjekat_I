package calculators;

import exceptions.NotSupportedOperationException;
import exceptions.NumberNotInAreaException;

/**
 * This class extends class Calculator.
 * This class provides more features than the Calculator class.
 * @author Aleksandar Kekic
 * @version 1.0
 * @since 2023-02-0
 */
public class CalculatorAdvanced extends Calculator{
	
	/**
	 * This is defaul constructor.
	 */
	public CalculatorAdvanced() {super();}
	
	/**
	 * This method works differently depending on the paremeter.
	 * If the parameter is a digit then we calculate the power of the number.
	 * If the parameter is ! then we calculate the factorial.
	 * @param action This is the only parameter.This parameter could be a digit or !.
	 * @throws NotSupportedOperationException This method throws this exception when operation is invalid.
	 * @throws NumberNotInAreaException This method throws this exception when the currentValue is not greater then 10 or lower than 0.
	 */
	public void calculateAdvanced(char action) throws NotSupportedOperationException,NumberNotInAreaException  {
		if(isValidOperation(action)) {
			if(Character.isDigit(action)) {
				Integer digit=Character.getNumericValue(action);
				super.setCurrentValue(Double.valueOf(powFunction(digit,super.getCurrentValue())));
			}else {
				if(super.getCurrentValue()>=0 && super.getCurrentValue()<=10)
					super.setCurrentValue(factorialFuncion());
				else
					throw new NumberNotInAreaException("CurrentValue is greater than 10 or lower than 0");
					
			}
		}else {
			throw new NotSupportedOperationException();
		}
	}
	
	/**
	 * This method works differently depending on the paremeter.
	 * If the value of the parameter is 'A', then we calculate whether curentvalue is amstrong's number.
	 * If the value of the parameter is 'P', then we calculate whether curentvalue is a perfect number.
	 * @param value This is the only parameter.Its value should be 'A' or 'P'.
	 * @return Method return true when the currentValue is perfect number or amstrong's number.
	 * @throws NumberNotInAreaException This method throws this exception when the currentValue is less then 1.
	 * @throws NotSupportedOperationException This method throws this exception when the currentValue is less then 1.
	 */
	public Boolean hasCharacteristic(char value) throws NumberNotInAreaException,NotSupportedOperationException{
		if(super.getCurrentValue()<1)
			throw new NumberNotInAreaException();
		else {
			switch(value) {
			case 'A':
				return isArmstrongNumber((int)super.getCurrentValue().doubleValue());
			case 'P':
				return isPerfectNumber((int)super.getCurrentValue().doubleValue());
			default:
				throw new NotSupportedOperationException("This operation is not supported.");
			}
		}
	}
	
	/**
	 * This method calculates the power of the number and has two parameters.
	 * @param exponent This is the first parameter and represents the exponent.
	 * @param base This is the second parameter and represents the base.
	 * @return This method returns the power of a number.
	 */
	private Integer powFunction(Integer exponent,Double base) {
		if(exponent==0)
			return 1;
		Integer currentValue=(int) Math.abs(base.doubleValue());
		Integer result=currentValue;
		for(int i=1;i<exponent;i++)
			result*=currentValue;
		if((int)base.doubleValue()<=-1 && exponent%2==1)
			return -Integer.valueOf(result);
		return Integer.valueOf(result);
	}
	
	/**
	 * This method calculates the factorial of a number and has no parameters.
	 * @return Method returns the factorial of the currentValue.
	 */
	public Double factorialFuncion() {
		Double result=1.0;
		Integer currentValueInt=(int)super.getCurrentValue().doubleValue();
		for(int i=1;i<=currentValueInt;i++)
			result=result*i;
		return result;
	}
	
	/**
	 * This method is called in calculateAdvanced method and its task is to check whether parameter is valid.
	 * If the parameter is a number in the range 0 to 10 or the character !, then it si valid.
	 * @param action This is the parameter we check.
	 * @return This method returns true value if the parameter is valid otherwise returns a false value.
	 */
	public boolean isValidOperation(char action){
		if(Character.isDigit(action)) {
			int digit=Character.getNumericValue(action);
			//if(digit>=0 && digit<10)
				return true;
		}else {
			if("!".equals(String.valueOf(action)))
				return true;
		}
		return false;
	}
	
	/**
	 * This method calculates whether a number is a perfect number.
	 * @param number This is the only parameter.
	 * @return This method returns a true value if the number is a perfect number.
	 */
	public boolean isPerfectNumber(int number) {
		if(number==0)
			return false;
	    int sum = 0;
	    for (int i = 1; i < number; i++) {
	        if (number % i == 0) {
	            sum += i;
	        }
	    }
	    return (sum == number);
	}
	
	/**
	 * This method calculates whether a number is an amstrong number.
	 * @param number This is the only parameter.
	 * @return This method returns a true value if the number is a perfect number.
	 */
	public boolean isArmstrongNumber(int number) {
		if(number<0)
			return false;
	    int originalNum = number;
	    int result = 0;
	    int n = 0;
	    while (originalNum != 0) {
	        originalNum /= 10;
	        ++n;
	    }
	    originalNum = number;
	    while (originalNum != 0) {
	        int remainder = originalNum % 10;
	        result += Math.pow(remainder, n);
	        originalNum /= 10;
	    }
	    return (result == number);
	}
	

}
