/**dp, 2차원 배열 누적 합**/
import java.io.*;
import java.util.StringTokenizer;

class Main_11660{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken()); //행렬 크기
        int m = Integer.parseInt(st.nextToken()); //답 구해야 할 횟수
        int[][] arr = new int[n + 1][n + 1]; //주어진 수 배열
        int[][] dp = new int[n + 1][n + 1]; //누적합 배열

        //arr 배열에 주어진 값 넣기
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //dp 배열에 누적합 넣기
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i -1][j - 1] + arr[i][j];
            }
        }

        //x1, y1, x2, y2
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int ans = dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1];
            sb.append(ans + "\n");
        }

        System.out.print(sb);

    }
}