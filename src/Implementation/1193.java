package Implementation;

import java.util.Scanner;

class Main_1193 {
    public static void main(String[] args) {
        Scanner scan = new Scanner((System.in));
        int x = scan.nextInt();
        int top = 0; // 분자
        int bottom = 0; // 분모
        int lineMax = 0; // 해당 대각선에서 최대 수
        int line = 0; // 대각선 카운트

        while (lineMax < x) { // 대각선 범위 안의 x 가 있도록 line, lineMax 구하기
            line++;
            lineMax += line;
        }

        if (line % 2 == 0) { // 짝수번째 대각선이면
            top = line + x - lineMax;
            bottom = lineMax - x + 1;
        } else { // 홀수번째 대각선이면 반대로
            top = lineMax - x + 1;
            bottom = line + x - lineMax;
        }

        System.out.println(top + "/" + bottom);
    }
}
