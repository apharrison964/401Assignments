package recitation;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testMultiply() {
		Calculator tester1 = new Calculator();
		assertEquals("10 x 5 must be 50", 50, tester1.multiply(10, 5));
	}
    @Test(expected = RuntimeException.class)
    public void testExceptionIsThrown(){
    	Calculator tester2 = new Calculator();
    	tester2.multiply(1000, 5);
    }
    
}
