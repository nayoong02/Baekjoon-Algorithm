package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_14503 {
    static int count = 0;
    static int N, M;
    static int[][] matrix;
    static int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = br.readLine();
        N = Integer.parseInt(firstLine.split(" ")[0]); // matrix 세로 길이
        M = Integer.parseInt(firstLine.split(" ")[1]); // matrix 가로 길이

        String secondLine = br.readLine();
        int r = Integer.parseInt(secondLine.split(" ")[0]); // 현재 위치 y 좌표
        int c = Integer.parseInt(secondLine.split(" ")[1]); // 현재 위치 x 좌표
        int d = Integer.parseInt(secondLine.split(" ")[2]); // 현재 위치에서 바라보는 방향

        matrix = new int[N][M];

        // matrix에 청소 여부 저장
        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(line.split(" ")[j]);
            }
        }

        clean(r, c, d);

        System.out.println(count);

    }

    static void clean(int r, int c, int d) {
        if (matrix[r][c] == 0) { // 현재 위치 청소 전이면 청소 후 카운트 증가
            matrix[r][c] = 2;
            count++;
        }

        for (int i = 0; i < 4; i++) { // 왼쪽으로 돌면서 탐색
            d = (d + 3) % 4; // 방향

            int nr = r + dr[d]; // 다음 r
            int nc = c + dc[d]; // 다음 c

            if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
                if (matrix[nr][nc] == 0) { // 벽 아니고 청소 안돼있으면
                    clean(nr, nc, d);

                    return; // 다시 되돌아와도 더 이상 탐색 못하게
                }
            }
        }

        // 4방향 모두 청소돼있거나 벽인 경우
        int bd = (d + 2) % 4; // 후진 방향
        int br = r + dr[bd]; // 후진 후 r
        int bc = c + dc[bd]; // 후진 후 c

        if (br >= 0 && bc >= 0 && br < N && bc < M && matrix[br][bc] != 1) { // 뒤쪽 칸이 벽이 아니라면
            clean(br, bc, d); // 원래 방향 유지한 채 후진
        }
    }

}
