package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main_15654 {
    static int N, M;
    static int[] arr;
    static int[] ansarr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        ansarr = new int[M];
        visited = new boolean[N];

        // 배열에 값 넣기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int n) {
        if (n == M) { // 종료 조건
            for (int i : ansarr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 백트래킹
        for (int j = 0; j < N; j++) {
            if (!visited[j]) {
                visited[j] = true;
                ansarr[n] = arr[j];
                dfs(n + 1);

                visited[j] = false;
            }
        }
    }
}
