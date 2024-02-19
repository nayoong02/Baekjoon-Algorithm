package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_1244 {
    static int switchnum, studnum;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        switchnum = Integer.parseInt(br.readLine()); // 스위치 개수
        arr = new int[switchnum + 1]; // 스위치 상태 배열

        // 스위치 배열에 상태 넣기
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= switchnum; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        studnum = Integer.parseInt(br.readLine()); // 학생 수
        for (int i = 0; i < studnum; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken()); // 성별
            int num = Integer.parseInt(st.nextToken()); // 학생이 받은 수

            change(gender, num);
        }

        print(arr);
    }

    // 성별에 따른 로직 처리
    static void change(int gender, int num) {
        if (gender == 1) { // 남자면
            for (int i = num; i <= switchnum; i += num) { // 배수 인덱스 스위치 변경
                switchOnoff(i);
            }
        } else { // 여자면
            int low = num - 1;
            int high = num + 1;
            switchOnoff(num);

            // 범위 안 && 대칭 체크
            while (low > 0 && high <= switchnum && arr[low] == arr[high]) {
                switchOnoff(low);
                switchOnoff(high);
                low--;
                high++;
            }
        }
    }

    // 스위치 on, off
    static void switchOnoff (int idx) {
        arr[idx] ^= 1;
    }

    // 정답 출력
    static void print(int[] arr) {
        for (int i = 1; i <= switchnum; i++) {
            System.out.print(arr[i] + " ");

            if (i % 20 == 0) { // 20개 출력 후 개행
                System.out.println();
            }
        }
    }
}
