package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_14888 {
    static int N;
    static int[] numbers; // 숫자 배열
    static int[] operators = new int[4]; // 연산자 배열
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        // 숫자 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(numbers[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    static void dfs(int num, int idx) {
        if (idx == N) { // 인덱스가 수 배열 끝까지 갔다면 판별 후 리턴
            MAX = Math.max(num, MAX);
            MIN = Math.min(num, MIN);
            return;
        }

        // 연산자 배열 탐색 (시작점)
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) { // 연산자가 1개 이상이면
                operators[i]--; // 연산자 사용할 것이므로 1 빼줌.

                // 연산자에 맞게 연산 후 dfs 호출
                switch (i) {
                    case 0: // +
                        dfs(num + numbers[idx], idx + 1);
                        break;
                    case 1: // -
                        dfs(num - numbers[idx], idx + 1);
                        break;
                    case 2: // *
                        dfs(num * numbers[idx], idx + 1);
                        break;
                    case 3: // /
                        dfs(num / numbers[idx], idx + 1);
                        break;
                }
                operators[i]++; // 연산자 다시 사용 가능하게 되돌려놓기
            }
        }
    }
}
