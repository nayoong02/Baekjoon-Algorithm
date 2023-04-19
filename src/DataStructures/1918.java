package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main_1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        String infix = br.readLine(); // 입력 받는 중위표기식
        StringBuilder sb = new StringBuilder(); // 출력할 후위표기식

        for (int i = 0; i < infix.length(); i++) {
            char element = infix.charAt(i);

            if (element == '(') {
                stack.push(element);
            } else if (element == ')') {
                if (!stack.isEmpty()) {
                    while (stack.peek() != '(') { // '(' 나오기 전까지 스택에 있는 원소 pop
                        sb.append(stack.pop());
                    }
                    stack.pop(); // 남아있는 '(' 제거
                }
            } else if (element == '*' || element == '/') {
                while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                    sb.append(stack.pop());
                }
                stack.push(element);
            } else if (element == '+' || element == '-') {
                while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '+' || stack.peek() == '-')) {
                    sb.append(stack.pop()); // 스택 최상위 원소가 연산기호이면 스택에 있던 원소 모두 출력 후 추가
                }
                stack.push(element);
            } else { // 피연산자인 경우
                sb.append(element);
            }
        }
        while (!stack.isEmpty()) { // 스택에 남아있는 연산자 모두 pop
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
