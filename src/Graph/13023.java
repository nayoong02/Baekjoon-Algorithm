package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main_13023 {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int N, M;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점 수
        M = Integer.parseInt(st.nextToken()); // 간선 수
        list = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        // 인접리스트에 연결된 간선 추가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        ans = 0;
        // N-1까지의 모든 정점에서 dfs를 통해 확인
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfs(i, 1);
            if (ans == 1) {
                System.out.println(ans);
                return;
            }
        }

        System.out.println(0);

    }

    static void dfs(int start, int depth) {
        if (depth == 5) {
            ans = 1;
            return;
        }
        visited[start] = true;
        for (int nxt : list[start]) {
            if (!visited[nxt]) {
                dfs(nxt, depth + 1);
            }
        }
        visited[start] = false;
    }
}