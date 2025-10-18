package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String expression = Console.readLine();

        if (expression.isBlank()) {
            System.out.println("0");
        } else {
            System.out.println("결과 : " + parseExpression(expression));
        }
    }

    public static int parseExpression(String expression) {
        int sum = 0;
        String separator = "[,:]";

        if (expression.startsWith("//") && expression.contains("\\n")) {
            separator = "[" + customParseExpression(expression) + "]";
            expression = expression.substring(expression.indexOf("n")+1);
        }

        String[] tokens = expression.split(separator);

        for (String token : tokens) {
            validateToken(token);
            sum += Integer.parseInt(token);
        }

        return sum;
    }

    public static String customParseExpression(String expression) {
        int start = expression.indexOf("//");
        int end = expression.indexOf("\\n");

        return expression.substring(start+2, end);
    }

    public static void validateToken(String token) {
        if (!token.matches("\\d+")) {
            throw new IllegalArgumentException();
        }

        if (Integer.parseInt(token) < 0) {
            throw new IllegalArgumentException();
        }
    }
}
