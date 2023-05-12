package DataStructures;

import java.util.LinkedList;
import java.util.Scanner;

class Main_1966 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int test = scan.nextInt(); // 테스트 케이스 수

        for (int i = 0; i < test; i++) {
            int N = scan.nextInt(); // 문서 개수
            int M = scan.nextInt(); // 궁금한 문서 인덱스
            int count = 0;
            LinkedList<int[]> queue = new LinkedList<>(); // 큐 생성

            // 큐에 {문서 인덱스, 중요도} add
            for (int j = 0; j < N; j++) {
                int importance = scan.nextInt(); // 문서 중요도
                queue.add(new int[]{j, importance});
            }

            while (!queue.isEmpty()) {
                int[] front = queue.poll(); // 큐의 첫 번째 문서 poll
                boolean isMax = true; // front의 중요도가 Max인지

                for (int k[] : queue) { // 큐 돌면서 front보다 중요도 큰 문서 있는지
                    if (front[1] < k[1]) { // 있으면
                        isMax = false;
                        break;
                    }
                }

                if (isMax == true) { // front의 중요도 가장 크면
                    count++;
                    if (front[0] == M) { // front의 인덱스와 M이 같다면 탐색 종료
                        break;
                    }
                } else { // isMax == false면 큐의 뒤로 front add
                    queue.add(front);
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}