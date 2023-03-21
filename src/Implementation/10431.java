package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_10431 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int P = Integer.parseInt(br.readLine());

        for (int i = 1; i <= P; i++) {
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[20];
            sb.append(st.nextToken()).append(" ");

            for (int j = 0; j < 20; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0; // 뒤로 물러난 횟수
            for (int k = 1; k < 20; k++) {
                for (int l = 0; l < k; l++) {
                    if (arr[l] > arr[k]) {
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");

        }

        System.out.println(sb);

    }
}