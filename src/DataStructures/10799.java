package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<Character> stack = new Stack<>();

        int count = 0; // 조각 개수
        for (int i = 0; i < line.length(); i++) {
            char bracket = line.charAt(i);
                if (bracket == '(' && line.charAt(i + 1) != ')') { // only '(' 인 경우
                    stack.push(bracket);
                } else if (bracket == ')') { // only ')' 인 경우
                    stack.pop();
                    count++;
                } else { // '(' 이후 ')' 연속으로 나오는 경우
                    i += 1; // 다음 인덱스는 반복문 건너뛰어야 해
                    count += stack.size();
                }
            }

        System.out.println(count);
    }
}
