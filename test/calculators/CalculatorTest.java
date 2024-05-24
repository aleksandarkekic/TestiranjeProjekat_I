package calculators;

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
import org.junit.jupiter.params.provider.MethodSource;

import exceptions.DivisionByZeroException;
import exceptions.NotSupportedOperationException;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;





@DisplayName("These are tests for the Calculator class.")
class CalculatorTest {

	private Calculator calculator=new Calculator();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		calculator.setCurrentValue(Double.valueOf(1));
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculator() {
		assertThat(calculator,is(notNullValue()));
	}

	@Test
	void testGetCurrentValue() {
		assertThat(Double.valueOf(1),is(calculator.getCurrentValue()));
		calculator.setCurrentValue(Double.valueOf(3));
		assertThat(Double.valueOf(3),is(calculator.getCurrentValue()));
		
	}

	@Test
	void testSetCurrentValue() {
		calculator.setCurrentValue(Double.valueOf(3));
		assertThat(Double.valueOf(3),is(calculator.getCurrentValue()));
		calculator.setCurrentValue(Double.valueOf(-3));
		assertThat(Double.valueOf(-3),is(calculator.getCurrentValue()));
		calculator.setCurrentValue(Double.valueOf(0));
		assertThat(Double.valueOf(0),is(calculator.getCurrentValue()));
		
		
	}

	@ParameterizedTest
	@MethodSource("methodWithParameters")
	public void testCalculateParametrized(Double value, char operator,Double result) throws Exception{
		calculator.calculate(value, operator);
		assertThat(result.doubleValue(),is(calculator.getCurrentValue()));
	}
	

	
	private static Stream<Arguments> methodWithParameters() {
	    return Stream.of(
	      Arguments.of(Double.valueOf(1),'+',Double.valueOf(2)),
	      Arguments.of(Double.valueOf(10),'+',Double.valueOf(11)),
	      Arguments.of(Double.valueOf(0),'+',Double.valueOf(1)),
	      Arguments.of(Double.valueOf(-1),'+',Double.valueOf(0)),
	      Arguments.of(Double.valueOf(-10),'+',Double.valueOf(-9)),
	      Arguments.of(Double.valueOf(1),'-',Double.valueOf(0)),
	      Arguments.of(Double.valueOf(10),'-',Double.valueOf(-9)),
	      Arguments.of(Double.valueOf(0),'-',Double.valueOf(1)),
	      Arguments.of(Double.valueOf(-1),'-',Double.valueOf(2)),
	      Arguments.of(Double.valueOf(-10),'-',Double.valueOf(11)),
	      Arguments.of(Double.valueOf(1),'*',Double.valueOf(1)),
	      Arguments.of(Double.valueOf(10),'*',Double.valueOf(10)),
	      Arguments.of(Double.valueOf(0),'*',Double.valueOf(0)),
	      Arguments.of(Double.valueOf(-1),'*',Double.valueOf(-1)),
	      Arguments.of(Double.valueOf(-10),'*',Double.valueOf(-10)),
	      Arguments.of(Double.valueOf(1),'/',Double.valueOf(1)),
	      Arguments.of(Double.valueOf(10),'/',Double.valueOf(0.1)),
	      Arguments.of(Double.valueOf(-1),'/',Double.valueOf(-1)),
	      Arguments.of(Double.valueOf(-10),'/',Double.valueOf(-0.1))
	    );
	}
	@DisplayName("Exceptions")
	@Test
	void testCalculateException() throws DivisionByZeroException,NotSupportedOperationException {

        Exception exception1 = assertThrows(
        		DivisionByZeroException.class, 
	            () ->calculator.calculate(Double.valueOf(0),'/'));
        assertThat(exception1, is(instanceOf(DivisionByZeroException.class)));
        
        Exception exception2 = assertThrows(
        		NotSupportedOperationException.class, 
	            () -> calculator.calculate(Double.valueOf(0),'#'));
        assertThat(exception2, is(instanceOf(NotSupportedOperationException.class)));
        
        Exception exception3 = assertThrows(
        		NotSupportedOperationException.class, 
	            () -> calculator.calculate(Double.valueOf(0),'a'));
        assertThat(exception3, is(instanceOf(NotSupportedOperationException.class)));
        
        Exception exception4 = assertThrows(
        		NotSupportedOperationException.class, 
	            () -> calculator.calculate(Double.valueOf(0),'5'));
        assertThat(exception4, is(instanceOf(NotSupportedOperationException.class)));
     
     
     
	}


}
