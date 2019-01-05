package pl.vachacz.antlr;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Calculator calc = new Calculator();

    @Test
    public void shouldCalculateSingleInt() {
        assertEquals(Integer.valueOf(1), calc.calculate("1"));
    }

    @Test
    public void shouldIgnoreBraces() {
        assertEquals(Integer.valueOf(1), calc.calculate("(1)"));
    }

    @Test
    public void shouldAddTwoIntegers() {
        assertEquals(Integer.valueOf(3), calc.calculate("1+2"));
    }

    @Test
    public void shouldMultiplyTwoIntegers() {
        assertEquals(Integer.valueOf(6), calc.calculate("2*3"));
    }

    @Test
    public void shouldSubtractTwoIntegers() {
        assertEquals(Integer.valueOf(5), calc.calculate("8-3"));
    }

    @Test
    public void shouldDevideTwoIntegers() {
        assertEquals(Integer.valueOf(5), calc.calculate("10/2"));
    }

    @Test
    public void shouldMultiplyFirst() {
        assertEquals(Integer.valueOf(14), calc.calculate("2+3*4"));
        assertEquals(Integer.valueOf(10), calc.calculate("2*3+4"));
    }

    @Test
    public void shouldEvaluateBraces() {
        assertEquals(Integer.valueOf(20), calc.calculate("(2+3)*4"));
        assertEquals(Integer.valueOf(14), calc.calculate("2*(3+4)"));
    }

    @Test
    public void shouldEvaluateExpressionWithTwoBraces() {
        assertEquals(Integer.valueOf(15), calc.calculate("(2+3)*(1+2)"));
    }

    @Test
    public void shouldEvaluateNestedExpression() {
        assertEquals(Integer.valueOf(12), calc.calculate("(2+(3-1))*(1+(4/2))"));
    }

    @Test
    public void shouldRecognizeInvalidExpressions() {
        thrown.expect(Exception.class);
        calc.calculate("-1");
    }

}
