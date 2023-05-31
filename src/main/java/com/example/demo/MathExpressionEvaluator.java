package com.example.demo;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MathExpressionEvaluator {

    public static String evaluateExpression(String expression) throws IOException {
        String url = "https://api.mathjs.org/v4/";
        String params = "expr=" + expression.replace(" ", "%20");
        URL apiURL = new URL(url + "?" + params);
        HttpURLConnection connection = (HttpURLConnection) apiURL.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String result = reader.readLine().trim();

        reader.close();
        connection.disconnect();

        return result;
    }

    public static void evaluateExpressions(String[] expressions) throws IOException {
        for (String expression : expressions) {
            if (expression.equals("end")) {
                break;
            }
            String result = evaluateExpression(expression);
            System.out.println(expression + " => " + result);
        }
    }

    public static void main(String[] args) throws IOException {
        String[] expressions = {
                "2 * 4 * 4",
                "5 / (7 - 5)",
                "sqrt(5^2 - 4^2)",
                "sqrt(-3^2 - 4^2)",
                "end"
        };
        evaluateExpressions(expressions);
    }
}