package DFS_BFS;

import java.util.*;
import java.io.*;

class Main_16953 {
    static long A,B;
    static int cnt;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        System.out.println(bfs());
    }

    static int bfs(){
        Queue<Long> queue = new LinkedList<>();
        queue.add(A);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                long tmp = queue.poll();
                if (tmp == B) {
                    return cnt + 1;
                }
                if (tmp * 2 <= B) {
                    queue.add(tmp * 2);
                }
                if (tmp * 10 + 1 <= B) {
                    queue.add(tmp * 10 + 1);
                }
            }
            cnt++;
        }
        return -1;
    }

}