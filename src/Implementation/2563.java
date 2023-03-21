package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[][] arr = new boolean[101][101];

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int bottom = Integer.parseInt(st.nextToken());

            // 정사각형 크기만큼 true로
            for (int r = left; r < left + 10; r++) {
                for (int c = bottom; c < bottom + 10; c++) {
                    arr[r][c] = true;
                }
            }
        }

        int count = 0; // 칠해진 부분 카운트
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[i][j]) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }
}