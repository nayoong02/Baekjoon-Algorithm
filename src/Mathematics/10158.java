package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_10158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken()); // 격자 가로
        int h = Integer.parseInt(st.nextToken()); // 격자 세로

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken()); // 초기 위치 가로 좌표
        int q = Integer.parseInt(st.nextToken()); // 초기 위치 세로 좌표

        int t = Integer.parseInt(br.readLine()); // 움직일 시간

        int x = (p + t) % (2 * w);
        int y = (q + t) % (2 * h);

        if (x > w) {
            x = (2 * w) - x;
        }

        if (y > h) {
             y = (2 * h) - y;
        }

        System.out.printf("%d %d", x, y);
    }
}
