package DFS_BFS;

import java.util.*;
import java.io.*;

class Main_2468 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N;
    static int[][] area;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE; // 최대 높이
    static int ans = 0; // 안전 영역 최대 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 2차원 배열의 변 길이
        area = new int[N][N]; // 지역 2차원 배열

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken()); // 높이 저장
                max = Math.max(max, area[i][j]); // 최대 높이 갱신
            }
        }

        // 0부터 최대 높이까지 지점 물에 잠겼다고 할 때 (0은 비가 안올 수도 있음 !!)
        for (int h = 1; h <= max; h++) {
            int[][] newArea = new int[N][N];
            visited = new boolean[N][N];
            int safe = 0; // 안전 영역 개수

            // 높이보다 같거나 작으면 새로운 배열에 잠기게 표시 (1로)
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (area[i][j] <= h) {
                        newArea[i][j] = 1;
                    }
                }
            }

            // 안 잠긴 부분 dfs 진행
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (newArea[i][j] == 0 && !visited[i][j]) {
                        dfs(newArea, i, j);
                        safe++;
                    }
                }
            }

            if (safe != 0) ans = Math.max(ans, safe); // 최대 안전 영역 개수 갱신
        }

        System.out.println(ans);
    }

    // 안전 영역 개수 구하기
    public static void dfs(int[][] arr, int x, int y) {
        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N){
                if (!visited[nx][ny] && arr[nx][ny] == 0) {
                    dfs(arr, nx, ny);
                }
            }
        }
    }
}
