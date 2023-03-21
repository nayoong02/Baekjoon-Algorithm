package TopologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main_1766 {
    static int N;
    static int M;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] indegree = new int[N + 1]; // 해당 노드를 가리키는 간선 갯수 담는 배열
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(); // 그래프 관계 표현 위한 2차원 인접 리스트

        // 리스트 생성
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            // first -> second
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            list.get(first).add(second);
            indegree[second]++;
        }

        topologicalSort(indegree, list);

    }

    // 위상 정렬
    static void topologicalSort(int[] indegree, ArrayList<ArrayList<Integer>> list) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 큐에 indegree가 0인 노드 담기
        for(int i = 1; i <= N; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        /** 큐에서 값을 하나씩 꺼내면서 해당 노드가 가리키는 노드의 indegree 1씩 감소
         *  만약 indegree가 0이 되면 큐에 넣기
         *  큐가 빌 때까지 반복
         */
        while(!queue.isEmpty()) {
            int res = queue.poll();

            for(Integer i : list.get(res)) {
                indegree[i]--;

                if(indegree[i] == 0) {
                    queue.offer(i);
                }
            }

            System.out.print(res + " ");
        }
    }
}
