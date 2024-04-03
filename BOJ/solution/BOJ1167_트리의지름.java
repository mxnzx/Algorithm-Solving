package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1167_트리의지름 {

    static class Node {
        int to;
        int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static int V, max, maxNode;
    static int[] diameter;
    static boolean[] visited;
    static ArrayList<Node>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V+1];
        diameter = new int[V+1];
        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while(true) {
                int to = Integer.parseInt(st.nextToken());
                if(to == -1) break;
                int w = Integer.parseInt(st.nextToken());
                tree[from].add(new Node(to, w));
            }
        }
        /*
        트리 지름 구하기
        1. 정점하나를 선택하고 가장 거리가 먼 정점 u을 찾는다. (여러개면 아무거나 하나)
        2. 정점 u에서 가장 거리가 먼 정점 v를 찾는다.
        3. 트리 지름 = 정점 u와 v 사이의 거리
         */
        visited = new boolean[V+1];
        dfs(0, 1);
        max = 0;
        visited = new boolean[V+1];
        dfs(0, maxNode);
        System.out.println(max);

    }

    private static void dfs(int sum, int cur) {
        if(max < sum) {
            max = sum;
            maxNode = cur;
        }

        visited[cur] = true;
        for(Node next : tree[cur]) {
            if(visited[next.to]) continue;
            dfs(sum + next.weight, next.to);
        }
    }
}
