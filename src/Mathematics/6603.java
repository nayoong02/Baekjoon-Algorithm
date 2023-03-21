package Mathematics; /**조합 백트래킹**/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_6603{
    static int n;
    static int r = 6;
    static int[] arr;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n == 0) break;

            arr = new int[n];
            checked = new boolean[n];

            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Combination(0, 0);
            System.out.println();
        }
    }

    public static void print(){
        for(int i = 0; i < n; i++){
            if(checked[i]){
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    public static void Combination(int cnt, int index){ //cnt:지금까지 선택된 개수, index:현재 인덱스
        if(cnt == r){ //더 이상 뽑을 것이 없음 -> 출력 후 함수 종료
            print();
        }
        for(int i = index; i < n; i++){
            checked[i] = true; //현재 인덱스 포함해주기
            Combination(cnt + 1, i + 1); //중복되면 안되니까 index+1
            checked[i] = false; //초기화
        }
    }
}