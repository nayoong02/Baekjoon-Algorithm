package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int[] arr = new int[10]; // 0~9 숫자 배열

        for (int i = 0; i < line.length(); i++) {
            int num = line.charAt(i) - '0'; // 한 자리씩 자르기

            if (num == 9) { // 9면 6자리에 넣기
                arr[6]++;
            } else { // 나머지 숫자는 인덱스 칸에 맞게 넣기
                arr[num]++;
            }
        }

        arr[6] = (int) Math.ceil((double) arr[6] / 2); // 6이랑 9 같게 취급했으니까 2로 나눠주기
        Arrays.sort(arr); // 오름차순 정렬

        System.out.println(arr[9]); // 최대 카운트 출력
    }
}
