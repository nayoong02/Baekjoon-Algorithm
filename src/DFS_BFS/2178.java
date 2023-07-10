package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_2178 {
    static int N, M;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0}; // 서, 남, 동, 북
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M]; // 미로 2차원 배열

        for (int i = 0; i < N; i++) {
            String line= br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(line.split("")[j]);
            }
        }

        bfs(0, 0);
        System.out.println(arr[N - 1][M - 1]);
    }

    static void bfs(int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[101][101];

        queue.offer(new int[]{n, m}); // 큐에 추가
        visited[n][m] = true; // 방문 처리

        while (!queue.isEmpty()) {
            int[] c = queue.poll();
            int cn = c[0]; // 현재 y인덱스
            int cm = c[1]; // 현재 x인덱스

            for (int i = 0; i < 4; i++) { // 동서남북 둘러보기
                int nn = cn + dy[i]; // 이동할 다음 y 인덱스
                int nm = cm + dx[i]; // 이동할 다음 x 인덱스

                // 범위를 벗어나면 pass
                if (nn < 0 || nm < 0 || nn >= N || nm >= M) continue;

                // 길이 아니거나 방문했다면 pass
                if (arr[nn][nm] == 0 || visited[nn][nm]) continue;

                // 범위 내에 있고, 길이거나 아직 방문전이라면
                queue.offer(new int[]{nn, nm}); // 큐에 추가
                visited[nn][nm] = true; // 방문 처리
                arr[nn][nm] = arr[cn][cm] + 1; // 배열에 카운트 갱신
            }

        }

    }
}
