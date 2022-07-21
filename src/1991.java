import java.util.Scanner;

class Node {
    char data;
    Node left;
    Node right;

    public Node(char data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class BinaryTree {
    Node root;

    //노드 생성
    public void createNode(char data, char left, char right) {
        if(root == null){ //root가 null(.)이라면 새 노드 생성(맨 처음)
            root = new Node(data);
            root.left = new Node(left);
            root.right = new Node(right);
        }
        else { //root가 null이 아니라면 탐색으로 넘어감
            searchNode(root, data, left, right);
        }
    }
    
    public void searchNode(Node node, char data, char left, char right){
        if(node == null){ //빈노드일 경우
            return;
        }
        else if(node.data == data){ //노드 찾은 경우 left, right 삽입
            node.left = new Node(left);
            node.right = new Node(right);
        }
        else { //못 찾았으면 왼쪽, 오른쪽으로 재귀 탐색
            searchNode(node.left, data, left, right);
            searchNode(node.right, data, left, right);
        }
    }

    //전위순회
    public void preOrder(Node node) {
        if (node.data == '.') {
            return;
        }
        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    //중위순회
    public void inOrder(Node node) {
        if (node.data == '.') {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data);
        inOrder(node.right);
    }

    //후위순회
    public void postOrder(Node node) {
        if (node.data == '.') {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
    }
}

class Main_1991 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        int n = scan.nextInt(); //트리 사이즈

        for (int i = 1; i <= n; i++) {
            char data = scan.next().charAt(0);
            char left = scan.next().charAt(0);
            char right = scan.next().charAt(0);
            tree.createNode(data, left, right);
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
    }
}









