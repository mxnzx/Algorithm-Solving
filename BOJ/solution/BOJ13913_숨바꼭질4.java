package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ13913_숨바꼭질4 {
    static class Node {
        int node, cnt;

        public Node(int node, int cnt) {
            this.node = node;
            this.cnt = cnt;
        }
    }
    static int[] dist;
    static boolean[] v;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());   //동생

        dist = new int[100001];
        v = new boolean[100001];

        bfs();

    }
    private static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N, 0));
        v[N] = true;

        ArrayList<Integer> alist = new ArrayList<>();

        while(!q.isEmpty()) {
            Node p = q.poll();


            if(p.node == K) {
                System.out.println(p.cnt);
                System.out.println(alist);
                return;
            }

            //x-1 일때
            int next = p.node - 1;
            if(next<0 || next > 100000 || v[next]) continue;
            q.add(new Node(next, p.cnt+1));
            //x+1 일때
            next = p.node + 1;
            if(next<0 || next > 100000 || v[next]) continue;
            q.add(new Node(next, p.cnt+1));
            //2*x 일때
            next = p.node * 2;
            if(next<0 || next > 100000 || v[next]) continue;
            q.add(new Node(next, p.cnt+1));
        }
    }
}
