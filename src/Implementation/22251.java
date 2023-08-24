package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_22251 {
    static int N, K, P, X;
    static int[][] display = {
            {1, 1, 1, 1, 1, 1, 0}, // 0
            {0, 0, 0, 0, 1, 1, 0}, // 1
            {1, 0, 1, 1, 0, 1, 1}, // 2
            {1, 0, 0, 1, 1, 1, 1}, // 3
            {0, 1, 0, 0, 1, 1, 1}, // 4
            {1, 1, 0, 1, 1, 0, 1}, // 5
            {1, 1, 1, 1, 1, 0, 1}, // 6
            {1, 0, 0, 0, 1, 1, 0}, // 7
            {1, 1, 1, 1, 1, 1, 1}, // 8
            {1, 1, 0, 1, 1, 1, 1} // 9
    };
    static int count; // 가능한 경우의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int[] x_digit = num_to_digit(X);
        check(x_digit);
        System.out.println(count);

    }

    // 1 ~ N 층까지 가능한 경우의 수 구하기
    public static void check(int[] x_digit) {
        for (int i = 1; i <= N; i++) {
            if (i == X) continue; // 현재 층이면 넘어가고
            if (can_reverse(i, x_digit)) count++; // 반전해서 만들 수 있는지 체크 후 카운트 증가
        }
    }

    // 반전해서 타겟 층수를 만들 수 있는지 체크
    public static boolean can_reverse(int target, int[] x_digit) {
        int[] target_digit = num_to_digit(target); // 타겟 층을 디지털로 표시

        int reverse_count = 0;
        for (int i = 0; i < K; i++) { // 한 자리씩
            for (int j = 0; j < 7; j++) { // 디지털 작대기 7개
                if (display[x_digit[i]][j] != display[target_digit[i]][j]) { // 배열 양상이 다르면 반전시켜야하므로
                    reverse_count++; // 반전시켜야 할 카운트 증가

                    if (reverse_count > P) return false; // 반전 시킨 카운트가 최대 반전 횟수를 넘으면 false 리턴
                }
            }
        }

        return true;
    }

    // 현재 층 수를 K 자리의 디지털로 표시
    public static int[] num_to_digit(int X) {
        int[] res = new int[K];

        for (int i = K - 1; i >= 0; i--) {
            res[i] = X % 10;
            X /= 10;
        }
        return res;
    }
}
