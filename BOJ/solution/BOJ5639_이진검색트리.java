package solution;

import java.io.*;

public class BOJ5639_이진검색트리 {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

        // 나보다 작으면 왼쪽 서브트리로, 크면 오른쪽 서브트리로
        void insert(int n) {
            if(n < this.data) {
                if(this.left == null) this.left = new Node(n);
                else this.left.insert(n);
            } else {
                if(this.right == null) this.right = new Node(n);
                else this.right.insert(n);
            }
        }
    }

    static Node root;

    static void postOrder(Node node) {
        if(node != null) {
            if(node.left != null) postOrder(node.left);
            if(node.right != null) postOrder(node.right);
            ans.append(node.data).append("\n");
        }
    }

    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        root = new Node(Integer.parseInt(br.readLine()));
        // 전위 순회(루트-왼-오) 결과가 주어졌을 때, 이 트리를 후위 순회(왼-오-루)한 결과를 구해라
        String input;
        while(true) {
            input = br.readLine();
            if(input == null) break;

            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
        System.out.println(ans);
    }
}