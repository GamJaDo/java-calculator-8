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

        String[] tokens = expression.split(separator);

        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }

        return sum;
    }
}
