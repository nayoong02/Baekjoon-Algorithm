package DFS_BFS; /**BFS와 DFS(인접리스트로 구현)**/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main_1260_2 {
    static int n, m, v;
    static boolean[] visited = new boolean[1001];
    static ArrayList<Integer>[] adjlist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); //정점 개수
        m = Integer.parseInt(st.nextToken()); //간선 개수
        v = Integer.parseInt(st.nextToken()); //처음 노드
        adjlist = new ArrayList[n + 1]; //인접 리스트

        //초기화(꼭 필요)
        for (int i = 0; i < adjlist.length; i++) {
            adjlist[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) { //연결리스트에 노드 추가
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjlist[a].add(b);
            adjlist[b].add(a);
        }

        //오름차순으로 정렬(자식 여러개면 작은 것부터 방문)
        for (int i = 0; i < adjlist.length; i++) {
            Collections.sort(adjlist[i]);
        }

        dfs(v);
        Arrays.fill(visited, false); //visited 배열 false로 초기화
        System.out.println();
        bfs(v);

    }

    public static void dfs(int v){
        visited[v] = true;
        System.out.print(v + " ");

        for(int e : adjlist[v]){
            if(!visited[e]){ //방문 전이라면 재귀
                dfs(e);
            }
        }
    }

    public static void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()){
            int c = queue.poll();
            System.out.print(c + " ");

            for(int e : adjlist[c]){
                if(!visited[e]){
                    visited[e] = true;
                    queue.add(e);
                }
            }
        }

    }

}
