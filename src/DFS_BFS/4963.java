package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_4963 {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dy = {0, 1, 0, -1, -1, 1, 1, -1};
    static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int h, w, nX, nY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) { // "0 0" 나오기 전까지 반복
            String line = br.readLine();
            if (line.equals("0 0")) break;
            else {
                w = Integer.parseInt(line.split(" ")[0]); // 너비
                h = Integer.parseInt(line.split(" ")[1]); // 높이
            }

            arr = new int[h][w];
            visited = new boolean[h][w];

            // arr 배열에 채워 넣기
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && arr[i][j] == 1) { // 방문 전이고 땅이면
                        ans++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(ans);
        }
    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 8; i++) { // 8 방향 탐색
            nY = dy[i] + y;
            nX = dx[i] + x;

            if (inRange() && !visited[nY][nX] && arr[nY][nX] == 1) { // 범위 안 && 방문 전 && 땅이면
                dfs(nY, nX);
            }
        }
    }

    public static boolean inRange() {
        return nX >= 0 && nX < w && nY >= 0 && nY < h;
    }
}
