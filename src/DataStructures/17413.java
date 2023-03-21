package DataStructures; /**문자열 스택**/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main_17413{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack stack = new Stack();
        boolean in = false; // <> 안에 있는지

        for(int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '<') {
                in = true;
                while (!stack.isEmpty()) { //지금까지의 스택 출력
                    System.out.print(stack.peek());
                    stack.pop();
                }
                System.out.print(line.charAt(i));
            } else if (line.charAt(i) == '>') {
                System.out.print(line.charAt(i));
                in = false;
            } else if (in) {
                System.out.print(line.charAt(i));
            } else if (line.charAt(i) == ' ') {
                while (!stack.isEmpty()) { //지금까지의 스택 출력
                    System.out.print(stack.peek());
                    stack.pop();
                }
                System.out.print(line.charAt(i));
            } else {
                stack.push(line.charAt(i));
            }

            if (i == line.length() - 1) {
                while (!stack.isEmpty()) { //지금까지의 스택 출력
                    System.out.print(stack.peek());
                    stack.pop();
                }
            }

        }
    }
}