package DFS_BFS; /**BFS와 DFS(인접행렬로 구현)**/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_1260{
    static int[][] Dgraph = new int[1001][1001];
    static int[][] Bgraph = new int[1001][1001];
    static boolean[] Dvisited = new boolean[1001];
    static boolean[] Bvisited = new boolean[1001];
    static int n, m, v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); //정점 개수
        m = Integer.parseInt(st.nextToken()); //간선 개수
        v = Integer.parseInt(st.nextToken()); //처음 노드

        for(int i = 0; i < m; i++){ //그래프 매핑
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Dgraph[a][b] = Dgraph[b][a] = 1;
            Bgraph[a][b] = Bgraph[b][a] = 1;

        }

        dfs(v);
        System.out.println();
        bfs(v);

    }

    public static void dfs(int v){
        Dvisited[v] = true; //현재 노드 방문 처리
        System.out.print(v + " ");

        for(int i = 1; i <= n; i++){
            if(Dgraph[v][i] == 1 && !Dvisited[i]){ //인접 노드 있고 아직 방문 전이라면 재귀
                dfs(i);
            }
        }
    }

    public static void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        Bvisited[v] = true; //현재 노드 방문 처리
        queue.offer(v); //시작 노드 추가

        //큐 빌 때까지 반복
        while (!queue.isEmpty()){
            int c = queue.poll(); //맨 앞 노드 꺼내기
            System.out.print(c + " ");

            for(int i = 1; i <= n; i++){
                if(Bgraph[c][i] == 1 && !Bvisited[i]){ //인접 노드 있고 아직 방문 전이라면
                    Bvisited[i] = true; //방문 처리 후
                    queue.add(i); //큐 맨 뒤에 노드 추가
                }
            }
        }

    }
}
