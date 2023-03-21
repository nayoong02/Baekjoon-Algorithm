package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_5639 {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }

        void insert(int data) {
            if (data < this.data) { //입력 값이 작다면 왼쪽 탐색
                if (this.left == null) { //this의 왼쪽이 비어있다면 바로 왼쪽에 삽입
                    this.left = new Node(data);
                } else { //아니라면 왼쪽으로 재귀 탐색
                    this.left.insert(data);
                }
            } else { //입력 값이 크다면 오른쪽 탐색
                if (this.right == null) { //this의 오른쪽이 비어있다면 바로 오른쪽에 삽입
                    this.right = new Node(data);
                } else { //아니라면 오른쪽으로 재귀 탐색
                    this.right.insert(data);
                }
            }
        }
    }
        public static void main(String[] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            Node root = new Node(Integer.parseInt(in.readLine())); //첫 입력되는 원소는 root가 됨

            //그 다음부터 원소 입력 받음
            while (true) {
                String n = in.readLine();
                if (n == null  || n.equals("")) { //null이면 원소 입력 받기 중지
                    break;
                }
                root.insert(Integer.parseInt(n)); //root 기준으로 입력 받은 원소 n 트리에 삽입
            }
            postOrder(root);
        }

        //후위순회로 출력
        static void postOrder(Node node) {
            if (node == null) {
                return;
            }
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }

}

