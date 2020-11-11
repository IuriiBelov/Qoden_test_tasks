package task3;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Solver {
    public static void main(String[] args) {
        String inputData = getInputData();
        System.out.println(calculate(inputData));
    }

    private static String getInputData() {
        Scanner in = new Scanner(System.in);
        String inputData = in.nextLine();
        in.close();
        return inputData;
    }

    private static int calculate(String inputData) {
        String[] tokens = inputData.split(" ");
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; ++i) {
            if (isOperation(tokens[i])) {
                int operand1 = deque.pollLast();
                int operand2 = deque.pollLast();
                int result = 0;

                switch (tokens[i]) {
                    case "+":
                        result = operand2 + operand1;
                        break;
                    case "-":
                        result = operand2 - operand1;
                        break;
                    case "*":
                        result = operand2 * operand1;
                        break;
                    case "/":
                        result = operand2 / operand1;
                }
                deque.addLast(result);
            } else {
                deque.addLast(Integer.parseInt(tokens[i]));
            }
        }
        return deque.pollLast();
    }

    private static boolean isOperation(String token) {
        return (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
    }
}
