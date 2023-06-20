package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();

        for (int i = 1; i <= N; i++) {
            int top = Integer.parseInt(st.nextToken()); // 맨 위 원소

            while (!stack.isEmpty()) {
                if (stack.peek()[1] >= top) { // 넣으려는 원소보다 스택의 맨 위 원소가 크거나 같을 때
                    sb.append(stack.peek()[0] + " "); // 맨 위 원소의 위치 인덱스 출력
                    break;
                }
                stack.pop(); // 넣으려는 원소가 더 클 때 pop
            }
            if (stack.isEmpty()) { // 스택이 비어있을 때 0 출력 후 push
                sb.append("0" + " ");
            }
            stack.push(new int[]{i, top});

        }

        System.out.println(sb);
    }

}
