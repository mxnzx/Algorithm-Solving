package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1991_트리순회 {
    static class Node {
        char data;
        Node left;
        Node right;

        Node(char data) {
            this.data = data;
        }
    }

    static Node root;

    static void createNode(char data, char left, char right) {
        if (root == null) {
            root = new Node(data);
            if (left != '.') root.left = new Node(left);
            if (right != '.') root.right = new Node(right);
        } else {
            if (left != '.' || right != '.') searchNode(root, data, left, right);
        }
    }

    static void searchNode(Node node, char data, char left, char right) {
        if (node == null) return;
        else if (node.data == data) {
            if (left != '.') node.left = new Node(left);
            if (right != '.') node.right = new Node(right);
        } else {
            searchNode(node.left, data, left, right);
            searchNode(node.right, data, left, right);
        }
    }

    // 전위 순회: root > left > right
    static void preOrder(Node node) {
        if (node != null) {
            sb.append(node.data);
            if(node.left != null) preOrder(node.left);
            if(node.right != null) preOrder(node.right);
        }
    }
    // 중위 순회: left > root > right
    static void inOrder(Node node) {
        if(node != null) {
            if(node.left != null) inOrder(node.left);
            sb.append(node.data);
            if(node.right != null) inOrder(node.right);
        }
    }
    // 후위 순회: left > right > root
    static void postOrder(Node node) {
        if(node != null) {
            if(node.left != null) postOrder(node.left);
            if(node.right != null) postOrder(node.right);
            sb.append(node.data);
        }
    }

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            createNode(str.charAt(0), str.charAt(2), str.charAt(4));
        }
        preOrder(root);
        sb.append("\n");
        inOrder(root);
        sb.append("\n");
        postOrder(root);
        System.out.println(sb);
    }
}
