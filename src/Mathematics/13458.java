package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N]; // 시험장 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken()); // 총감독 관리 인원
        int C = Integer.parseInt(st.nextToken()); // 부감독 관리 인원

        long ans = 0; // 필요한 최소 감독 수
        for (int i = 0; i < N; i++) {
            ans += 1; // 총감독은 필수로 1명 들어가야 됨.

            int sub = arr[i] - B; // 부감독 인원 수 계산
            if (sub > 0) {
                ans += sub / C; // 몫 더해주고

                if (sub % C > 0) { // 나머지 있으면 +1 (올림)
                    ans += 1;
                }
            }
        }

        System.out.println(ans);
    }
}
