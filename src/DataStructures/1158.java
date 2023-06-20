package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// LinkedList
class Main_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> list = new LinkedList<>();

        String line = br.readLine();
        int N = Integer.parseInt(line.split(" ")[0]);
        int K = Integer.parseInt(line.split(" ")[1]);

        for (int i = 1; i <= N; i++) { // 리스트에 원소 넣기
            list.add(i);
        }

        StringBuffer sb = new StringBuffer();
        sb.append("<");

        int index = 0;
        while (list.size() > 1) { // 원소가 1개보다 많을 때 반복
            index = (index + K - 1) % list.size(); // 인덱스 계속 갱신
            sb.append(list.remove(index)).append(", ");
        }

        sb.append(list.remove()).append(">"); // 원소 한 개 남았을 때

        System.out.println(sb);
    }
}

// // Queue
//class Main_1158 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Queue<Integer> queue = new LinkedList<>();
//
//        String line = br.readLine();
//        int N = Integer.parseInt(line.split(" ")[0]);
//        int K = Integer.parseInt(line.split(" ")[1]);
//
//        for (int i = 1; i <= N; i++) { // 큐에 원소 넣기
//            queue.add(i);
//        }
//
//        StringBuffer sb = new StringBuffer();
//        sb.append("<");
//
//        while (queue.size() > 1) { // 원소가 1개보다 많을 때 반복
//            for (int i = 0; i < K - 1; i++) { // K - 1 번째까지는 큐 뒤로 원소 보내기
//                queue.offer(queue.poll());
//            }
//            sb.append(queue.poll()).append(", "); // K번째 원소 poll
//        }
//
//        sb.append(queue.poll()).append(">"); // 원소 한 개 남았을 때
//
//        System.out.println(sb);
//    }
//
//}
