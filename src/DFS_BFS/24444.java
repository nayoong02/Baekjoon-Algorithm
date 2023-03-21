package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main_24444 {

    static int cnt; //방문 순서
    static int[] visited; //방문 순서 배열
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(v); //큐 맨 뒤에 시작 정점 추가
        visited[v] = cnt++; //방문 표시

        while (!queue.isEmpty()) {
            int c = queue.poll(); //큐의 맨 앞 원소 삭제

            for (int i = 0; i < graph.get(c).size(); i++) { //정점 c의 인접리스트
                int d = graph.get(c).get(i);
                if (visited[d] == 0) { //아직 방문 전이면
                    queue.offer(d); //큐 맨 뒤에 정점 추가 후 방문 표시
                    visited[d] = cnt++;
                }
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
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        //그래프 입력 받고 노드 연결
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b); //무방향 그래프이므로 두 정점 잇기
            graph.get(b).add(a);
        }

        //노드마다 오름차순
        for (int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        cnt = 1;
        visited = new int[n + 1];
        bfs(r);

        for (int i = 0; i < visited.length; i++) {
            if (i != 0) { //1번 인덱스부터 출력
                System.out.println(visited[i]);
            }
        }
    }
}