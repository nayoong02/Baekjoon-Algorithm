package String;

import java.util.Scanner;
import java.util.Stack;

class Main_4949 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            String line = scan.nextLine();

            if (line.equals(".")) break;

            if (balanced(line)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

    }

    public static boolean balanced(String line) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);

            // 여는 괄호인 경우 스택에 push
            if (currentChar == '(' || currentChar == '[') {
                stack.push(currentChar);
            }
            // 닫는 괄호인 경우 스택이 비어있거나 짝이 맞지 않으면 균형이 안 맞는 것이므로 false 반환
            else if (currentChar == ')' || currentChar == ']') {
                if (stack.isEmpty()) {
                    return false;
                }

                char topChar = stack.pop();
                if ((currentChar == ')' && topChar != '(') || (currentChar == ']' && topChar != '[')) {
                    return false;
                }
            }
            // 괄호 외의 다른 문자들은 무시
        }

        return stack.isEmpty();

    }
}
