import java.io.*;
import java.util.*;

class Main_14501 {
    static int N;
    static int[][] schedule;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        schedule = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken()); // T
            schedule[i][1] = Integer.parseInt(st.nextToken()); // P
        }

        result = 0;
        dfs(0, 0);

        System.out.println(result);
    }

    static void dfs(int idx, int pay) {
        if (idx >= N) { // idx 가 N 이상이면 result 최댓값 구하고 끝내기
            result = Math.max(result, pay);
            return;
        }

        if (idx + schedule[idx][0] <= N) { // 상담 끝낸 날이 N 이하이면 상담 끝난 날짜, 상담비 합쳐서 넘김.
            dfs(idx + schedule[idx][0], pay + schedule[idx][1]);
        } else { // N 넘어가면 상담 끝난 날짜만 넘겨줌.
            dfs(idx + schedule[idx][0], pay);
        }

        dfs(idx + 1, pay); // 다음 날짜로 넘어가 마지막 날짜까지 모든 경우 탐색

    }
}
