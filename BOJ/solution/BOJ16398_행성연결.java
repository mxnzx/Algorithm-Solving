package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ16398_행성연결 {
    static class Node {
        int e,c;

        public Node(int e, int c) {
            this.e = e;
            this.c = c;
        }

        public int getC() {
            return c;
        }

    }
    static int[][] adjMatrix;
    static int[] dist;
    static boolean[] v;
    static int N;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        adjMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        v = new boolean[N];
        dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        //인덱스 0번의 노드부터 탐색하며
        dist[0]=0;
        prim(0);


    }

    private static void prim(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(Node::getC));
        q.add(new Node(0,0));

        long sum = 0;

        while (!q.isEmpty()) {
            Node p = q.poll();


            int next;
            if(!v[p.e]) {
                v[p.e] = true;
                sum += p.e;
                for (int i = 0; i < N; i++) {

                        if(adjMatrix[i][j] != 0) {
                            next = adjMatrix[i][j];
                            if (!v[next] && dist[p.e] > next) {
                                dist[p] = next;
                                q.add(new Node(i, ))
                            }
                        }

                }
            }


        }
    }
}
