package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main_12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 승환 앞 학생들 수
        Stack<Integer> stack = new Stack<>();
        String ans = "Nice";

        int curr = 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num != curr) { // 순서 안맞으면
                while (!stack.isEmpty()) { // 현재 스택 일단 체크
                    if (stack.peek() == curr) { // 순서 맞으면 꺼내고 순서 증가
                        stack.pop();
                        curr++;
                    } else { // 아니면 탈출
                        break;
                    }
                }
                stack.push(num); // 현재 번호 스택에 넣기
            } else { // 순서 맞으면 통과 후 순서 증가
                curr++;
                continue;
            }
        }

        // 스택에 남아있는 것 처리
        while (!stack.isEmpty()) {
            if (stack.peek() == curr) { // 순서 맞으면 꺼내고 순서 증가
                stack.pop();
                curr++;
            } else { // 안 맞으면 바로 중단
                ans = "Sad";
                break;
            }
        }

        System.out.println(ans);
    }
}
