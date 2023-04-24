package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ1922_네트워크연결 {
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
    static int N,M;
    static boolean[] v;
    static int[] dist;
    static ArrayList<Node>[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        int a,b,c;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            adjList[a].add(new Node(b,c));
            adjList[b].add(new Node(a,c));
        }

        v = new boolean[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1]=0;
        //프림
        prim();
    }
    private static void prim() {
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(Node::getCost));
        q.add(new Node(1,0));

        int sum=0;
        while (!q.isEmpty()) {
            Node p = q.poll();

            if(v[p.node]) continue;
            v[p.node] = true;
            sum += dist[p.node];

            for(Node next: adjList[p.node]) {
                if(!v[next.node] && dist[next.node] > next.cost){
                    dist[next.node] = next.cost;
                    q.add(next);
                }
            }
        }
        System.out.println(sum);
    }
}
