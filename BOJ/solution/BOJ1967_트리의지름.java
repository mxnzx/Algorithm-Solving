package solution;

import java.util.*;
import java.io.*;

public class BOJ1967_트리의지름 {

    static class Node {
        int idx, weight;

        Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    static List<Node>[] trees;
    static boolean[] visited;
    static int max, maxIdx = 1;

    static void dfs(int now, int total) {

        if(max < total) {
            max = total;
            maxIdx = now;
        }

        for(Node next : trees[now]) {
            if(visited[next.idx]) continue;
            visited[next.idx] = true;
            dfs(next.idx, total + next.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        trees = new ArrayList[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            trees[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            trees[p].add(new Node(c, w));
            trees[c].add(new Node(p, w));
        }
        // 가장 먼 노드를 고른다
        visited[1] = true;
        dfs(1, 0);

        // 다시 가장 먼 노드를 고른다
        visited = new boolean[n+1];
        visited[maxIdx] = true;
        dfs(maxIdx, 0);

        System.out.println(max);
    }
}
