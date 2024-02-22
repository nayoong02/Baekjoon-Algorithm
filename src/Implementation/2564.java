package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_2564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken()); // 블록의 가로 길이
        int h = Integer.parseInt(st.nextToken()); // 블록의 세로 길이
        int shop = Integer.parseInt(br.readLine()); // 상점의 개수
        int[] arr = new int[shop]; // 상점까지의 거리 배열

        int tmp = 0; // 상점까지의 거리
        int dong = 0; // 동근까지의 거리

        for (int i = 0; i < shop + 1; i++) {
            st = new StringTokenizer(br.readLine());

            int dir = Integer.parseInt(st.nextToken()); // 상점이 위치한 방향
            int len = Integer.parseInt(st.nextToken()); // 상점까지의 거리

            switch (dir) {
                case 1: // 북쪽
                    tmp = len;
                    break;
                case 2: // 남쪽
                    tmp = w + h + (w - len);
                    break;
                case 3: // 서쪽
                    tmp = w + h + w + (h - len);
                    break;
                case 4: // 동쪽
                    tmp = w + len;
                    break;
            }

            // 거리 저장
            if (i < shop) { // 상점까지의 거리들
                arr[i] = tmp;
            } else { // 동근까지의 거리
                dong = tmp;
            }
        }

        int ans = 0;
        for (int i = 0; i < shop; i++) { // 2방향 모두 계산 후 최소값 선택
            int path1 = Math.abs(arr[i] - dong);
            int path2 = 2 * (w + h) - path1;

            ans += Math.min(path1, path2);
        }

        System.out.println(ans);
    }
}
