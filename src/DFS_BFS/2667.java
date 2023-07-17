package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Main_2667 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int count = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        // map 입력받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line.split("")[j]);
            }
        }

        ArrayList<Integer> list = new ArrayList<>(); // 단지별 집 수 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 0; // 단지별 집 수 초기화
                    dfs(i, j);
                    list.add(count);
                }
            }
        }

        // 오름차순 출력
        System.out.println(list.size());
        Collections.sort(list);
        for (int i : list) System.out.println(i);

    }

    static int dfs(int x, int y) {
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int newx = x + dx[i];
            int newy = y + dy[i];

            if (newx >= 0 && newx < N && newy >= 0 && newy < N) {
                if (!visited[newx][newy] && map[newx][newy] == 1) {
                    dfs(newx, newy);
                }
            }
        }
        return count;
    }

}
