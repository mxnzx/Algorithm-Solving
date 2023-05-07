package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16562_친구비 {
    static class Node {
        int node, cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        public int getCost() {
            return cost;
        }
    }
    static int N, M, k;
    static ArrayList<Integer>[] adjList;
    static int[] friend, parents;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        friend = new int[N+1];
        adjList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
            friend[i] = Integer.parseInt(st.nextToken());
        }

        parents = new int[N+1];
        //make-set
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < M; i++) {
            int from,to;
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
            union(from,to);
        }
        //System.out.println(Arrays.toString(parents));




    }
    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(pa != pb) {
            if(pa < pb) parents[pb] = pa;
            else parents[pa] = pb;
        }
    }
    private static int find(int a) {
        if(parents[a] == a) return a;
        else return parents[a] = find(parents[a]);
    }
}
