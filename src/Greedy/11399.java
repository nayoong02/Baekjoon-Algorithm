package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 사람 수

        int[] arr = new int[N]; // 시간 넣을 배열
        String line = br.readLine();

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(line.split(" ")[i]);
        }

        Arrays.sort(arr); // 오름차순 정렬

        int sum = 0; // 누적합
        for(int i = 0; i < N; i++) {
            sum += arr[i];
            for(int j = 0; j < i; j++) {
                sum += arr[j];
            }
        }

        System.out.println(sum);
    }
}