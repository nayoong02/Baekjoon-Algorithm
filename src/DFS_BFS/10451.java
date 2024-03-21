package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main_10451 {

    static int[] arr;
    static int cycle;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 순열 크기
            arr = new int[N + 1];
            check = new boolean[N + 1];
            cycle = 0;

            // 순열 입력받기
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            // dfs 진행
            for (int k = 1; k < N + 1; k++) {
                if (!check[k]) {
                    dfs(k);
                    cycle++;
                }
            }
            sb.append(cycle).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int start) {
        check[start] = true;

        int next = arr[start];
        if (!check[next]) {
            dfs(next);
        }
    }
}
