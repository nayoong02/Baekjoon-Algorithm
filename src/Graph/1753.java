package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main_1753 {
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] dist;

    static class Node {
        int v; // 정점
        int w; // 가중치

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점 개수
        int E = Integer.parseInt(st.nextToken()); // 간선 개수
        int K = Integer.parseInt(br.readLine()); // 시작 정점

        graph = new ArrayList[V + 1]; // 정점 및 간선 저장
        visited = new boolean[V + 1]; // 방문 여부 저장
        dist = new int[V + 1]; // 최단 거리 저장

        // 그래프, 거리 배열 초기화
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        // 간선 연결
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken()); // 시작 정점
            int e = Integer.parseInt(st.nextToken()); // 도착 정점
            int w = Integer.parseInt(st.nextToken()); // 가중치

            graph[s].add(new Node(e, w));
        }

        dijkstra(K);

        // 출력
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }

    // 다익스트라 알고리즘
    static void dijkstra(int k) {
        // 우선순위큐 가중치 오름차순 정렬
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);

        // 시작 노드 초기화
        queue.add(new Node(k, 0));
        dist[k] = 0;

        while (!queue.isEmpty()) {
            // 현재 최단 거리 가장 짧은 노드 꺼내기
            Node tmp = queue.poll();

            // 방문 안했다면 방문 처리
            if (!visited[tmp.v]) {
                visited[tmp.v] = true;
            }

            for (Node next : graph[tmp.v]) {
                // 아직 방문 전 && 현재 노드 거쳐 다음 노트로 이동하는 거리 더 짧을 경우
                if (!visited[next.v] && dist[next.v] > tmp.w + next.w) {
                    dist[next.v] = tmp.w + next.w; // 갱신 후 큐에 추가
                    queue.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}
