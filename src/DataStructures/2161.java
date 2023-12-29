package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Main_2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>(); // 제거되는 원소 넣을 리스트

        // 큐에 1~N 넣기
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        // 원소 1개 남을 때까지 반복
        while (queue.size() != 1) {
            list.add(queue.poll()); // 맨 위 제거
            queue.add(queue.poll()); // 그 다음 위를 빼서 맨 뒤로 추가
        }

        // 리스트 출력
        for (int l : list) {
            System.out.print(l + " ");
        }

        // 큐에 남아있는 마지막 원소 출력
        System.out.println(queue.poll());

    }
}
