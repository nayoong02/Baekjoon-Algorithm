package Implementation;

import java.util.Scanner;

class Main_1236 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); // 성의 세로 크기
        int M = scan.nextInt(); // 성의 가로 크기
        char[][] matrix  = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = scan.next();

            for (int j = 0; j < M; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }

        // 행마다 필요한 경비원 수
        int row = 0;
        for (int i = 0; i < N; i++) {
            boolean flag = false;

            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 'X') {
                    flag = true;
                    break;
                }
            }
            if (!flag) row++;
        }

        // 열마다 필요한 경비원 수
        int col = 0;
        for (int i = 0; i < M; i++) {
            boolean flag = false;

            for (int j = 0; j < N; j++) {
                if (matrix[j][i] == 'X') {
                    flag = true;
                    break;
                }
            }
            if (!flag) col++;
        }

        // 행, 열마다 필요한 경비원의 최대 수 출력
        System.out.println(Math.max(row, col));
    }
}
