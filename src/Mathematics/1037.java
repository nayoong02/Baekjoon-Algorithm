package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main_1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N의 진짜 약수 개수
        int[] arr = new int[N];

        // 배열에 숫자 넣기
        String line = br.readLine();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(line.split(" ")[i]);
        }

        Arrays.sort(arr); // 정수배열 오름차순 정렬
        int min = arr[0];
        int max = arr[arr.length - 1];

        // 약수 중 1과 자기 자신 빠지면 결국 남은 약수 중 최소 * 최대 곱하면 그 수 됨.
        System.out.println(min * max);

    }
}
