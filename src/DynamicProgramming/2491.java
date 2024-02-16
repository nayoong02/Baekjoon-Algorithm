package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main_2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수열의 길이

        // 배열에 값 넣기
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] incrarr = new int[N]; // 증가하는 배열
        int[] decrarr = new int[N]; // 감소하는 배열

        // 첫번째 카운트 값은 1
        incrarr[0] = 1;
        decrarr[0] = 1;

        // 증가하는 배열 체크
        int i = 1;
        while (i < N) {
            if (arr[i] >= arr[i - 1]) { // 같거나 커지는 경우
                incrarr[i] = incrarr[i - 1] + 1;
            } else { // 나머지 경우
                incrarr[i] = 1;
            }
            i++;
        }

        Arrays.sort(incrarr); // 오름차순 정렬
        int incMax = incrarr[N - 1]; // 증가 수열의 최대 길이

        // 감소하는 배열 체크
        i = 1;
        while (i < N) {
            if (arr[i] <= arr[i - 1]) { // 같거나 작아지는 경우
                decrarr[i] = decrarr[i - 1] + 1;
            } else { // 나머지 경우
                decrarr[i] = 1;
            }
            i++;
        }

        Arrays.sort(decrarr); // 오름차순 정렬
        int decMax = decrarr[N - 1]; // 감소 수열의 최대 길이

        System.out.println(Integer.max(incMax, decMax));

    }
}
