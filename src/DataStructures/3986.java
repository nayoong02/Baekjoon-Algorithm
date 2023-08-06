package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < word.length(); j++) {
                if (!stack.isEmpty() && stack.peek() == word.charAt(j)) {
                    stack.pop();
                } else {
                    stack.push(word.charAt(j));
                }
            }

            if (stack.isEmpty()) count++;
        }

        System.out.println(count);
    }
}
