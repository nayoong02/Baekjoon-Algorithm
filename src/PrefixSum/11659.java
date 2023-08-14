package PrefixSum; /**누적합 : accum[j] - accum[i - 1]**/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_11659{
    static int[] arr;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 수의 개수
        int m = Integer.parseInt(st.nextToken()); // 합 구해야하는 횟수

        arr = new int[n + 1]; // 누적합 저장할 배열
        arr[0] = 0; // 0번째 인덱스는 0으로 초기화

        // 누적합 배열에 저장
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i + 1] = arr[i] + Integer.parseInt(st.nextToken());
        }

        // 구간합 구하기
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int first_idx = Integer.parseInt(st.nextToken());
            int last_idx = Integer.parseInt(st.nextToken());

            accumulate(first_idx, last_idx);
            System.out.println(ans);
        }
    }

    public static void accumulate(int first_idx, int last_idx){
        ans = arr[last_idx] - arr[first_idx - 1];
    }
}
