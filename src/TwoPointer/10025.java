package TwoPointer; // Sliding Window

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_10025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 배열에 인덱스별 얼음 양 저장
        int[] arr = new int[1000001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            arr[x] = g;
        }

        int sum = 0;
        int max = 0;
        int window = (2 * K) + 1; // 슬라이딩 윈도우 크기

        for (int i = 0; i <= 1000000; i++) {
            if (i >= window) { // 직전 배열과 현재 배열 중 겹치지 않는 부분 빼기
                sum -= arr[i - window];
            }
            sum += arr[i]; // 현재 배열 중 겹치는 부분 추가로 더하기
            max = Math.max(max, sum); // 최댓값 구하기
        }

        System.out.println(max);
    }
}
