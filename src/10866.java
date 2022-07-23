import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Main_10866 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> deque = new LinkedList<Integer>();

        for(int i=0; i<n; i++) {
            String[] com = br.readLine().split(" ");

            if(com[0].equals("push_front")){
                int m = Integer.parseInt(com[1]);
                deque.addFirst(m);
            }
            else if(com[0].equals("push_back")) {
                int m = Integer.parseInt(com[1]);
                deque.addLast(m);
            }
            else if(com[0].equals("pop_front")) {
                if(deque.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(deque.peekFirst()).append('\n');
                    deque.pollFirst(); }
            }
            else if(com[0].equals("pop_back")) {
                if(deque.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(deque.peekLast()).append('\n');
                    deque.pollLast(); }
            }
            else if(com[0].equals("size")) {
                sb.append(deque.size()).append('\n');
            }
            else if(com[0].equals("empty")) {
                if(deque.isEmpty()) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            }
            else if(com[0].equals("front")) {
                if(deque.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(deque.peekFirst()).append('\n');
                }
            }
            else if(com[0].equals("back")) {
                if(deque.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(deque.peekLast()).append('\n');
                }
            }
        }
        System.out.println(sb);

    }

}
