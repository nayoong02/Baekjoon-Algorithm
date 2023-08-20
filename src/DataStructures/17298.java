package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 수열 크기

        // 수열에 저장
        int[] sequence = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        // 결과 배열
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && sequence[stack.peek()] < sequence[i]) { // 스택이 비어있지 않고, 현재 수열의 원소가 스택의 맨위 원소보다 크면
                result[stack.pop()] = sequence[i];
            }
            stack.push(i); // 인덱스 저장
        }

        while (!stack.isEmpty()) { // 아직 정답 찾지 못하고 스택에 원소 남아있으면
            result[stack.pop()] = -1;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(result[i] + " ");
        }

        System.out.println(sb);
    }
}
