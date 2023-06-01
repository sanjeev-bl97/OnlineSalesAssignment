import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MathExpressionEvaluator {

    public static String evaluateExpression(String expression) throws IOException {

        String url = "https://api.mathjs.org/v4/";


        try{
        //Building the URL and encoding with UTF-8 encoder to handle spaces and operators in Query Parameter
        String encodedExpression = URLEncoder.encode(expression, "UTF-8");
        URL apiURL = new URL(url + "?expr=" + encodedExpression);

        //Establishing http connection for the URL and GET request method is called upon the connection to get the response
        HttpURLConnection connection = (HttpURLConnection) apiURL.openConnection();
        connection.setRequestMethod("GET");


        int statusCode = connection.getResponseCode();

        //If status code is 200 getting the result string using Input stream and buffer Reader
        if (statusCode == HttpURLConnection.HTTP_OK) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String result = reader.readLine().trim();

        reader.close();
        connection.disconnect();

        return result;

            }

            else {
                throw new IOException("HTTP Error: " + statusCode);
            }
        }
        //Handling the exception if any http error occurs
       catch (IOException e) {

           return "Error: " + e.getMessage();
        }
    }

    public static void evaluateExpressions(String[] expressions) throws IOException {
        //Evaluating each expression's one by one and printing the answer
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