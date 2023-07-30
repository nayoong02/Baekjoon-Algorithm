package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = Integer.MAX_VALUE;
        StringTokenizer sub = new StringTokenizer(br.readLine(), "-");

        while (sub.hasMoreTokens()) { // 뺄셈으로 토큰 분리 후
            int temp = 0;

            StringTokenizer add = new StringTokenizer(sub.nextToken(), "+");

            while (add.hasMoreTokens()) { // 뺄셈으로 나뉜 토큰들 안에서 덧셈 연산 수행
                temp += Integer.valueOf(add.nextToken());
            }

            if (answer == Integer.MAX_VALUE) { // 첫 원소는 그냥 넣어주고
                answer = temp;
            } else { // 뒤로는 빼기 연산자 적용
                answer -= temp;
            }
        }

        System.out.println(answer);
    }
}
