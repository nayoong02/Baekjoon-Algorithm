package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_1992 {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        // 배열 입력 받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(line.split("")[j]);
            }
        }

        divide(N, 0, 0);
        System.out.println(sb);
    }

    static void divide(int n, int x, int y) {

        // 압축 가능하면 하나의 색으로 압축 (0 or 1)
        if (isPossible(n, x, y)) {
            sb.append(arr[x][y]);
            return;
        }

        // 압축 안되면 사이즈 절반으로 나누기
        int newSize = n / 2;

        sb.append("(");
        divide(newSize, x, y); // 왼쪽 위
        divide(newSize, x, y + newSize); // 오른쪽 위
        divide(newSize, x + newSize, y); // 왼쪽 아래
        divide(newSize, x + newSize, y + newSize); // 오른쪽 아래
        sb.append(")");
    }

    // 압축 가능한지 체크하는 함수
    static boolean isPossible(int n, int x, int y) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[x][y] != arr[i][j]) { // 다르면
                    return false;
                }
            }
        }
        return true;
    }
}
