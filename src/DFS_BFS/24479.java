package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main_24479{
    static int cnt; //방문 순서
    static int[] visited; //방문 순서 배열
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void dfs(int v){
        visited[v] = cnt;
        for(int i = 0; i < graph.get(v).size(); i++){
            int y = graph.get(v).get(i); //연결된 노드
            if(visited[y] == 0){ //방문 안했으면
                cnt++; //순차 증가
                dfs(y);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); //정점 개수
        int m = Integer.parseInt(st.nextToken()); //간선 개수
        int r = Integer.parseInt(st.nextToken()); //처음 노드

        //그래프 초기화
        for(int i = 0; i < n + 1; i++){
            graph.add(new ArrayList<Integer>());
        }

        //그래프 입력 받고 노드 연결
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b); //무방향 그래프이므로 두 정점 잇기
            graph.get(b).add(a);
        }

        //노드마다 오름차순
        for(int i = 0; i < graph.size(); i++){
            Collections.sort(graph.get(i));
        }
        cnt = 1;
        visited = new int[n+1];
        dfs(r);

        for(int i = 0; i < visited.length; i++){
            if(i != 0){ //1번 인덱스부터 출력
                System.out.println(visited[i]);
            }
        }
    }

}