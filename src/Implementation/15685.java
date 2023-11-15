package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main_15685 {
    static int[] dx = {1, 0, -1, 0}; // x 이동 좌표 (반시계 방향)
    static int[] dy = {0, -1, 0, 1}; // y 이동 좌표
    static boolean[][] matrix = new boolean[101][101];
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 드래곤 커브 개수
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 시작점 x
            int y = Integer.parseInt(st.nextToken()); // 시작점 y
            int d = Integer.parseInt(st.nextToken()); // 시작 방향
            int g = Integer.parseInt(st.nextToken()); // 세대

            draw(x, y, d, g);
        }

        // 1 * 1 정사각형 개수 구하기
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (matrix[i][j] && matrix[i + 1][j] && matrix[i][j + 1] && matrix[i + 1][j + 1]) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    public static void draw(int x, int y, int d, int g) {
        ArrayList<Integer> dlist = new ArrayList<>(); // 방향 담을 리스트
        dlist.add(d); // 처음 방향 추가

        for (int i = 0; i < g; i++) { // g 세대만큼 반복
            for (int j = dlist.size() - 1; j >= 0; j--) { // 리스트 끝에서부터
                dlist.add((dlist.get(j) + 1) % 4); // 반시계 방향 저장
            }
        }

        // x, y 좌표 이동하며 꼭짓점 그리기
        matrix[y][x] = true;
        for (int dir : dlist) {
            x += dx[dir];
            y += dy[dir];
            matrix[y][x] = true;
        }
    }
}
