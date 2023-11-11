package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main_2644 {
    static int n;
    static boolean[] visited;
    static int a, b, m;
    static ArrayList<Integer>[] list;
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 전체 사람 수
        visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken()); // 구해야할 수1
        b = Integer.parseInt(st.nextToken()); // 구해야할 수2
        m = Integer.parseInt(br.readLine()); // 부모, 자식들 간 관계 수

        list = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[p].add(c);
            list[c].add(p);
        }

        dfs(a,0);
        System.out.println(ans);
    }

    static void dfs(int a, int cnt) {
        if (a == b) { // 시작점과 끝점 같게 도달하면
            ans = cnt;
            return;
        }
        visited[a] = true;

        for (int i : list[a]) {
            if (!visited[i]) {
                dfs(i, cnt + 1);
            }
        }
    }
}
