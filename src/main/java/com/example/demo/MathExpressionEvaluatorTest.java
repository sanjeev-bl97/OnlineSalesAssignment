import org.junit.Assert;
import org.junit.Test;

public class MathExpressionEvaluatorTest {

    @Test
    public void testBasicArithmeticExpression() {
        String expression = "2 + 3 * 4 - 5 / 2";
        double expected = 2 + 3 * 4 - 5 / 2.0;

        double result = MathExpressionEvaluator.evaluate(expression);
        Assert.assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testExpressionWithParentheses() {
        String expression = "(2 + 3) * (4 - 1)";
        double expected = (2 + 3) * (4 - 1);

        double result = MathExpressionEvaluator.evaluate(expression);
        Assert.assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testExpressionWithPowerOperator() {
        String expression = "2 ^ 4";
        double expected = Math.pow(2, 4);

        double result = MathExpressionEvaluator.evaluate(expression);
        Assert.assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testExpressionWithSquareRoot() {
        String expression = "sqrt(25)";
        double expected = Math.sqrt(25);

        double result = MathExpressionEvaluator.evaluate(expression);
        Assert.assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testExpressionWithNegativeNumbers() {
        String expression = "-5 + 3 * -2";
        double expected = -5 + 3 * -2;

        double result = MathExpressionEvaluator.evaluate(expression);
        Assert.assertEquals(expected, result, 0.0001);
    }
}
