package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Main_10866 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> deque = new LinkedList<>(); //덱 생성

        for(int i=0; i<n; i++) {
            String[] com = br.readLine().split(" ");

            switch (com[0]) {
                case "push_front" : {
                    deque.addFirst(Integer.parseInt(com[1]));
                    break;
                }
                case "push_back" : {
                    deque.addLast(Integer.parseInt(com[1]));
                    break;
                }
                case "pop_front" : {
                    if(deque.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(deque.pollFirst()).append('\n');
                    }
                    break;
                }
                case "pop_back" : {
                    if (deque.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(deque.pollLast()).append('\n');
                    }
                    break;
                }
                case "size" : {
                    sb.append(deque.size()).append('\n');
                    break;
                }
                case "empty" : {
                    if(deque.isEmpty()) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;
                }
                case "front" : {
                    if(deque.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(deque.peekFirst()).append('\n');
                    }
                    break;
                }
                case "back" : {
                    if(deque.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(deque.peekLast()).append('\n');
                    }
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
