package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_10819 {
    static int N;
    static int res = Integer.MIN_VALUE;
    static int[] arr, ans;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        ans = new int[N];
        visited = new boolean[N];

        StringTokenizer st =  new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(res);
    }

    static void dfs(int cnt) {
        if (cnt == N) {
            int sum = 0; // 차이 저장

            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(ans[i] - ans[i + 1]);
            }

            res = Math.max(res, sum);
            return;
        }

        // 모든 경우의 수 백트래킹
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                ans[cnt] = arr[i];
                visited[i] = true;
                dfs(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
