package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_20125 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine()); // 정사각형 한 변의 길이
        char[][] matrix = new char[N][N]; // 정사각형 배열

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }

        // 십장 찾기
        int hx = 0, hy = 0;
        boolean foundHeart = false;
        for (int i = 0; i < N && !foundHeart; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == '*') {
                    hx = i + 1; // 심장 x
                    hy = j; // 심장 y
                    foundHeart = true;
                    break;
                }
            }
        }
        sb.append(hx + 1).append(" ").append(hy + 1).append("\n");

        // 팔 구하기
        int la = 0, ra = 0;
        for (int k = 0; k < N; k++) {
            if (k < hy && matrix[hx][k] == '*') {
                la++;
            } else if (k > hy && matrix[hx][k] == '*') {
                ra++;
            }
        }
        sb.append(la).append(" ").append(ra).append(" ");

        // 허리 구하기
        int w = 0, wl = 0, wr = 0, wh = 0;
        for (int k = hx + 1; k < N; k++) {
                if (matrix[k][hy] == '*') {
                    w++;
                } else {
                    wh = k; // 다리 시작 x
                    wl = hy - 1; // 왼 다리 시작 y
                    wr = hy + 1; // 오른 다리 시작 y
                    break;
                }
        }
        sb.append(w).append(" ");

        // 다리 구하기
        int ll = 0, rl = 0;
        for (int k = wh; k < N && matrix[k][wl] == '*'; k++) {
            ll++;
        }
        for (int k = wh; k < N && matrix[k][wr] == '*'; k++) {
            rl++;
        }
        sb.append(ll).append(" ").append(rl);

        System.out.println(sb);

    }
}
