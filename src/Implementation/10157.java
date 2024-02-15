package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_10157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken()); // 공연장 가로 크기
        int R = Integer.parseInt(st.nextToken()); // 공연장 세로 크기
        int K = Integer.parseInt(br.readLine()); // 대기번호

        if (K > C * R) { // 대기번호 할당 불가능하면
            System.out.println(0);
            System.exit(0);
        } else { // 가능하면
            int num = 1; // 채울 대기 번호
            int[][] seats = new int[R][C]; // 공연장

            int i = R - 1, j = 0; // 좌표 시작
            int d = 1; // 위 방향부터 시작

            while (num <= C * R) {
                if (num == K) { // 대기번호까지 왔다면
                    System.out.println((j + 1) + " " + (R - i));
                    break;
                }

                // 자리 할당
                seats[i][j] = num;

                switch (d) {
                    case 1: // 위로 이동
                        if (i - 1 >= 0 && seats[i - 1][j] == 0) {
                            i--;
                            num++;
                        } else { // 오른쪽으로 방향 변경
                            d = 2;
                        }
                        break;
                    case 2: // 오른쪽으로 이동
                        if (j + 1 < C && seats[i][j + 1] == 0) {
                            j++;
                            num++;
                        } else { // 아래로 방향 변경
                            d = 3;
                        }
                        break;
                    case 3: // 아래로 이동
                        if (i + 1 < R && seats[i + 1][j] == 0) {
                            i++;
                            num++;
                        } else { // 왼쪽으로 방향 변경
                            d = 4;
                        }
                        break;
                    case 4: // 왼쪽으로 이동
                        if (j - 1 >= 0 && seats[i][j - 1] == 0) {
                            j--;
                            num++;
                        } else { // 위로 방향 변경
                            d = 1;
                        }
                        break;
                }
            }
        }
    }
}
