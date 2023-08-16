package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 수열 길이
        int s = Integer.parseInt(st.nextToken()); // 기준 숫자

        // 배열에 숫자 넣기
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int len = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;

        while (end <= n) {
            if (sum >= s) { // 합이 s보다 같거나 크면
                sum -= arr[start++]; // 합에서 arr[start] 빼주고 start++

                len = end - start + 1; // 부분합 길이
                ans = Math.min(ans, len); // 길이 갱신
            }
            else if (sum < s) { // s보다 작다면
                sum += arr[end++]; // arr[end] 더해주고 end++
            }

        }
        System.out.println((ans) == Integer.MAX_VALUE ? 0 : ans);
    }
}
