package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_1182 {
    static int N, S;
    static int[] arr;
    static boolean[] visited;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(S == 0 ? res - 1 : res); // 합이 0일 경우, 공집합 제거 !!!
    }

    static void dfs(int cnt, int sum) {
        if (cnt == N) {
            if (sum == S) {
                res++;
            }
            return;
        }

        dfs(cnt + 1, sum + arr[cnt]); // 해당 원소 선택 O
        dfs(cnt + 1, sum); // 해당 원소 선택 X
    }

}
