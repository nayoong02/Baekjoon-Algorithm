package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int melon = Integer.parseInt(br.readLine()); // 1m^2당 자라는 참외 개수

        int maxW = Integer.MIN_VALUE, maxH = Integer.MIN_VALUE; // 최대 가로, 세로 길이
        int maxWidx = 0, maxHidx = 0; // 최대 가로, 세로 길이의 인덱스

        int[] arr = new int[6]; // 변 길이 넣을 배열
        StringTokenizer st;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken()); // 변의 방향
            int len = Integer.parseInt(st.nextToken()); // 변의 길이
            arr[i] = len;

            if (d == 1 || d == 2) { // 동서 방향 (가로) 최대값 구하기 + 인덱스 저장
                if (maxW < len) {
                    maxW = len;
                    maxWidx = i;
                }
            } else { // 남북 방향 (세로) 최대값 구하기 + 인덱스 저장
                if (maxH < len) {
                    maxH = len;
                    maxHidx = i;
                }
            }
        }

        int bigArea = maxW * maxH; // 전체 큰 사각형 넓이
        // 최대 인덱스 앞뒤로 차끼리 곱한 작은 사각형의 넓이
        int smallArea = Math.abs(arr[((maxWidx - 1 + 6) % 6)] - arr[((maxWidx + 1 + 6) % 6)]) *
                        Math.abs(arr[((maxHidx - 1 + 6) % 6)] - arr[((maxHidx + 1 + 6) % 6)]);

        System.out.println((bigArea - smallArea) * melon);
    }
}
