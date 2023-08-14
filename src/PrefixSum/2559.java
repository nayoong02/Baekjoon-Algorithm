package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_2559 {
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 전체 날짜 수
        int k = Integer.parseInt(st.nextToken()); // 연속 날짜 수

        arr = new int[n + 1]; // 날짜 저장할 배열
        arr[0] = 0;
        int answer = Integer.MIN_VALUE;

        // 날짜 저장하기
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 구간합 최대 값 갱신
        for (int i = 1; i <= n - k + 1; i++) {
            int res = accum(i, i + k);
            answer = Math.max(answer, res);
        }

        System.out.println(answer);
    }

    public static int accum(int i, int j) {
        int res = 0;
        for (int s = i; s < j; s++) {
           res += arr[s];
        }
        return res;
    }
}
