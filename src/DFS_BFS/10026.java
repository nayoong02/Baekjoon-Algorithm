package DFS_BFS; /**DFS**/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_10026 {
    static char[][] map_n, map_p;
    static boolean[][] visited_n, visited_p;
    static int n, count_n, count_p;
    static int[] dy = {-1, 0, 1, 0}; //상, 좌, 하, 우(y축)
    static int[] dx = {0, -1, 0, 1}; //상, 좌, 하, 우(x축)


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map_n = new char[n][n]; //정상인 색상 담을 배열
        map_p = new char[n][n]; //적록색맹 색상 담을 배열
        visited_n = new boolean[n][n]; //정상인 방문 배열
        visited_p = new boolean[n][n]; //적록색맹 방문 배열
        count_n = 0; //정상인 영역 개수
        count_p = 0; //적록색맹 영역 개수

        //color map 안에 넣기
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                char color = line.charAt(j);
                map_n[i][j] = color;
                map_p[i][j] = color;

                //적록색맹의 map -> R, G 구분 없애주기
                if (color == 'R') {
                    map_p[i][j] = 'G';
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //정상인
                if (!visited_n[i][j]) { //방문 전이면
                    dfs(i, j, visited_n, map_n, map_n[i][j]);
                    count_n++;
                }
                //적록색맹
                if (!visited_p[i][j]) {
                    dfs(i, j, visited_p, map_p, map_p[i][j]);
                    count_p++;
                }
            }
        }

        System.out.print(count_n + " " + count_p);
    }

    public static void dfs(int y, int x, boolean[][] visited, char[][] map, char color) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) { //상하좌우 다 살피고
            int ni = y + dy[i];
            int nj = x + dx[i];

            //좌표가 범위 안에 있고 아직 탐색 전이고 현재 색깔과 다음 이동할 색깔이 같다면 이동
            if (ni >= 0 && ni < n && nj >= 0 && nj < n && !visited[ni][nj] && map[ni][nj] == color) {
                dfs(ni, nj, visited, map, color);
            }
        }
    }
}