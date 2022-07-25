//분할 정복, 재귀
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_2630{
    static int n; //2차원 배열 크기
    static int[][] arr; //2차원 정수 배열
    static int[] count; //정답 배열
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        arr = new int[n][n];
        count = new int[2];

        //2차원 배열 입력 받기
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(n, 0, 0);

        //정답 배열 출력
        for(int i : count){
            System.out.println(i);
        }

    }

    static void divide(int n, int y, int x){
        for(int i = y; i < y + n; i++){
            for(int j = x; j < x + n; j++){
                if(arr[y][x] != arr[i][j]){ //arr의 첫 번째 칸 (arr[y][x])과 다른 색이 나온다면 다시 분할 필요
                    int d = n / 2;
                    divide(d, y, x); //2사분면
                    divide(d, y, x + d); //1사분면
                    divide(d, y + d, x); //3사분면
                    divide(d, y + d, x + d); //4사분면

                    return; //큰 사분면(작은 사분면 4개 포함) 검사 끝나면 다음 큰 사분면으로 이동
                }
            }
        }

        count[arr[y][x]]++; //검사를 모두 통과(모두 같은 색)

    }
}