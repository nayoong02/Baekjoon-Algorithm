import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_10974{
    static int n;
    static int[] arr;
    static int[] output;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        output = new int[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            arr[i] = i + 1;
        }
        DFS(0);
    }

    public static void DFS(int depth){ //depth:output에 들어간 숫자의 개수
        if(depth == n){
            for(int i = 0; i < n; i++){
                System.out.print(output[i] + " ");
            }
            System.out.println();
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                DFS(depth + 1);
                visited[i] = false;
            }

        }
    }
}