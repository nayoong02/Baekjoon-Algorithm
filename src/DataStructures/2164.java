package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Main_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i); // 1 ~ N 까지 큐에 넣기
        }

        while (queue.size() > 1) { // 카드 1장 남을 때까지 반복
            queue.pollFirst(); // 맨 위 카드 제거
            queue.offerLast(queue.pollFirst()); // 그 다음 위 카드 맨 밑으로 이동
        }

        System.out.println(queue.peekFirst());
    }

}
