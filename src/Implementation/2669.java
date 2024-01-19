package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[][] matrix = new boolean[100][100];
        int count = 0;

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken()); // 왼쪽 아래 꼭짓점의 x좌표
            int ly = Integer.parseInt(st.nextToken()); // 왼쪽 아래 꼭짓점의 y좌표
            int rx = Integer.parseInt(st.nextToken()); // 오른쪽 위 꼭짓점의 x좌표
            int ry = Integer.parseInt(st.nextToken()); // 오른쪽 위 꼭짓점의 y좌표

            // 왼쪽 아래 ~ 오른쪽 위 꼭지점까지 채우기
            for (int x = lx; x < rx; x++) {
                for (int y = ly; y < ry; y++) {
                    if (!matrix[x][y]) { // 아직 방문 전이면 방문 처리 + 카운트
                        matrix[x][y] = true;
                        count++;
                    }
                }
            }
        }

        // 카운트 출력
        System.out.println(count);
    }
}
