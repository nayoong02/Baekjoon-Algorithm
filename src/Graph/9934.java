package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_9934 {
    static int K;
    static int[] arr;
    static StringBuffer[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        arr = new int[(int) Math.pow(2, K) - 1]; // 노드 개수가 2^K + 1인 트리
        ans = new StringBuffer[K]; // 정답 담을 버퍼

        // 버퍼 배열 초기화
        for (int i = 0; i < ans.length; i++) {
            ans[i] = new StringBuffer();
        }

        // 노드 -> 배열에 삽입
        String line = br.readLine();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(line.split(" ")[i]);
        }

        inOrder(0, 0, arr.length - 1);

        // 정답 출력
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

    }

    // 중위 순회
    public static void inOrder(int floor, int left, int right) {
        if (floor == K) return;

        int root = (left + right) / 2;
        ans[floor].append(arr[root] + " ");

        inOrder(floor + 1, left, root - 1); // 왼쪽
        inOrder(floor + 1, root + 1, right); // 오른쪽
    }
}
