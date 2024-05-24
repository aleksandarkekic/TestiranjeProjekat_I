package calculators;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import exceptions.DivisionByZeroException;
import exceptions.NotSupportedOperationException;
import exceptions.NumberNotInAreaException;


@DisplayName("These are tests for the CalculatorAdvanced class.")
class CalculatorAdvancedTest {

	CalculatorAdvanced calculatorAdvanced=new CalculatorAdvanced();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		calculatorAdvanced.setCurrentValue(Double.valueOf(1));
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculatorAdvanced() {
		assertThat(calculatorAdvanced,is(notNullValue()));
	}

	@Test
	@DisplayName("Exception hasCharacteristic")
	void testHasCharacteristicException() {
		
		  Exception exception1 = assertThrows(
				  NotSupportedOperationException.class, 
		            () ->calculatorAdvanced.hasCharacteristic('R'));
	        assertThat(exception1, is(instanceOf(NotSupportedOperationException.class)));
	        
	       Exception exception2 = assertThrows(
	    		   NotSupportedOperationException.class, 
		            () ->calculatorAdvanced.hasCharacteristic('a'));
	        assertThat(exception2, is(instanceOf(NotSupportedOperationException.class)));
	        
	       Exception exception3 = assertThrows(
		    		NotSupportedOperationException.class, 
			        () ->calculatorAdvanced.hasCharacteristic('!'));
		    assertThat(exception3, is(instanceOf(NotSupportedOperationException.class)));
		        
		        calculatorAdvanced.setCurrentValue(Double.valueOf(-5));
		    Exception exception4 = assertThrows(
		    		NumberNotInAreaException.class, 
				     () ->calculatorAdvanced.hasCharacteristic('A'));
			assertThat(exception4, is(instanceOf(NumberNotInAreaException.class)));
			        
			        calculatorAdvanced.setCurrentValue(Double.valueOf(0));
			Exception exception5 = assertThrows(
				    NumberNotInAreaException.class, 
		            () ->calculatorAdvanced.hasCharacteristic('A'));
			assertThat(exception5, is(instanceOf(NumberNotInAreaException.class)));
				        
	}
	@ParameterizedTest
	@MethodSource("methodWithParametersCharacteristic")	
	void testHasCharacteristic(char value,boolean result,Double numb) throws NumberNotInAreaException,NotSupportedOperationException{
		calculatorAdvanced.setCurrentValue(numb);
		assertThat(result,is(calculatorAdvanced.hasCharacteristic(value)));
	
	}
	private static Stream<Arguments> methodWithParametersCharacteristic() {
	    return Stream.of(
	      Arguments.of('A',true,Double.valueOf(3)),
	      Arguments.of('A',true,Double.valueOf(153)),
	      Arguments.of('A',true,Double.valueOf(2)),
	      Arguments.of('A',false,Double.valueOf(21)),
	      Arguments.of('P',true,Double.valueOf(6)),
	      Arguments.of('P',true,Double.valueOf(28)),
	      Arguments.of('P',false,Double.valueOf(18))
	    );
	}

	
	 @ParameterizedTest
     @CsvSource(value = {"3:false", "6:true", "28:true","-1:false","0:false","15:false","1:false"}, delimiter = ':')
	void testIsPerfectNumber(int number,boolean result) {
		assertThat(result,is(calculatorAdvanced.isPerfectNumber(number)));
	}

	 @ParameterizedTest
     @CsvSource(value = {"3:true", "0:true", "2:true","-1:false","153:true"}, delimiter = ':')
	void testIsArmstrongNumber(int number,boolean result) {
		assertThat(result,is(calculatorAdvanced.isArmstrongNumber(number)));
	}
	 
	@ParameterizedTest
	@MethodSource("methodWithParametersValid")	 
	 void isValidOperationTest(boolean result,char action) {
		assertThat(result,is(calculatorAdvanced.isValidOperation(action)));
	 }
	private static Stream<Arguments> methodWithParametersValid() {
	    return Stream.of(
	      Arguments.of(true,'9'),
	      Arguments.of(true,'2'),
	      Arguments.of(true,'2'),
	      Arguments.of(true,'0'),
	      Arguments.of(false,'#'),
	      Arguments.of(false,'a'),
	      Arguments.of(false,'V'),
	      Arguments.of(true,'!')
	    );
	}
	 
	 @ParameterizedTest
		@MethodSource("methodWithParameters")
		public void testCalculateAdvancedParametrized(Double currentValue, char action,Double result) throws Exception{
		 calculatorAdvanced.setCurrentValue(currentValue);
		 calculatorAdvanced.calculateAdvanced(action);
		 assertThat(result.doubleValue(),is(calculatorAdvanced.getCurrentValue()));
		}
		private static Stream<Arguments> methodWithParameters() {
		    return Stream.of(
		      Arguments.of(Double.valueOf(1),'9',Double.valueOf(1)),
		      Arguments.of(Double.valueOf(2),'2',Double.valueOf(4)),
		      Arguments.of(Double.valueOf(3),'3',Double.valueOf(27)),
		      Arguments.of(Double.valueOf(0),'0',Double.valueOf(1)),
		      Arguments.of(Double.valueOf(1),'0',Double.valueOf(1)),
		      Arguments.of(Double.valueOf(0),'1',Double.valueOf(0)),
		      Arguments.of(Double.valueOf(-1),'1',Double.valueOf(-1)),
		      Arguments.of(Double.valueOf(-3),'2',Double.valueOf(9)),
		      Arguments.of(Double.valueOf(-3),'1',Double.valueOf(-3)),
		      Arguments.of(Double.valueOf(-3),'0',Double.valueOf(1)),
		      Arguments.of(Double.valueOf(0),'9',Double.valueOf(0)),
		      Arguments.of(Double.valueOf(1),'!',Double.valueOf(1)),
		      Arguments.of(Double.valueOf(0),'!',Double.valueOf(1)),
		      Arguments.of(Double.valueOf(10),'!',Double.valueOf(3628800)),
		      Arguments.of(Double.valueOf(4),'!',Double.valueOf(24)),
		      Arguments.of(Double.valueOf(5),'!',Double.valueOf(120))
  );
}
		@DisplayName("Exceptions calculateAdvance")
		@Test
		void testCalculateAdvacneException() throws NumberNotInAreaException,NotSupportedOperationException {
			calculatorAdvanced.setCurrentValue(Double.valueOf(-1));
	        Exception exception1 = assertThrows(
	        		NumberNotInAreaException.class, 
		            () ->calculatorAdvanced.calculateAdvanced('!'));
	        assertThat(exception1, is(instanceOf(NumberNotInAreaException.class)));
	        
	        calculatorAdvanced.setCurrentValue(Double.valueOf(11));
	        Exception exception2 = assertThrows(
	        		NumberNotInAreaException.class, 
		            () ->calculatorAdvanced.calculateAdvanced('!'));
	        assertThat(exception2, is(instanceOf(NumberNotInAreaException.class)));
	        
	        Exception exception3 = assertThrows(
	        		NotSupportedOperationException.class, 
		            () ->calculatorAdvanced.calculateAdvanced('#'));
	        assertThat(exception3, is(instanceOf(NotSupportedOperationException.class)));
	        
	        Exception exception4 = assertThrows(
	        		NotSupportedOperationException.class, 
		            () ->calculatorAdvanced.calculateAdvanced('V'));
	        assertThat(exception4, is(instanceOf(NotSupportedOperationException.class)));
	   	}

}
