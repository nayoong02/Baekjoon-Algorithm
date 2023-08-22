package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main_5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine()); // 전화번호 수
            String[] arr = new String[n];

            for (int j = 0; j < n; j++) { // 전화번호 배열에 저장
                arr[j] = br.readLine();
            }

            Arrays.sort(arr); // 오름차순 정렬

            if (check(arr)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    // 일관성 체크
    public static boolean check(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i  + 1].startsWith(arr[i])) { // 일관성 X
                return  false;
            }
        }
        return true;
    }
}
