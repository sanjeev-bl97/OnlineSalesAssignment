import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class MathExpressionEvaluatorTest {

    @Test
    public void testEvaluateExpression_Addition() throws IOException {
        String expression = "2 + 3";
        String expected = "5";

        String result = MathExpressionEvaluator.evaluateExpression(expression);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testEvaluateExpression_Subtraction() throws IOException {
        String expression = "10 - 5";
        String expected = "5";

        String result = MathExpressionEvaluator.evaluateExpression(expression);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testEvaluateExpression_Multiplication() throws IOException {
        String expression = "2 * 4";
        String expected = "8";

        String result = MathExpressionEvaluator.evaluateExpression(expression);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testEvaluateExpression_Division() throws IOException {
        String expression = "10 / 2";
        String expected = "5";

        String result = MathExpressionEvaluator.evaluateExpression(expression);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testEvaluateExpression_SquareRoot() throws IOException {
        String expression = "sqrt(16)";
        String expected = "4";

        String result = MathExpressionEvaluator.evaluateExpression(expression);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testEvaluateExpression_InvalidExpression() throws IOException {
        String expression = "2 + ABC"; // Invalid expression
        String expected = "Error: HTTP Error: 400";

        String result = MathExpressionEvaluator.evaluateExpression(expression);

        Assertions.assertEquals(expected, result);
    }
}

