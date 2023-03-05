/*
 * [BOJ]13549. 숨바꼭질3
 * 다익스트라 - 가중치 있고, 최단 경로를 구해야 하므로!!
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ13549_숨바꼭질3 {
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
    static int N, K;
    static int[] dist = new int[100001];
    static boolean[] v = new boolean[100001];
    static final int INF = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, INF);
        dist[N] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(Node::getC));
        q.add(new Node(N,0));

        while (!q.isEmpty()) {
            Node p = q.poll();
            int minIdx = p.e;
            int minDist = p.c;
            v[minIdx] = true;
            //System.out.println(minIdx + " " + minDist);

            //목표 지점 오면 종료
            if(minIdx == K) {
                System.out.println(minDist);
                break;
            }

            //뒤로 가는 경우
            int next = minIdx - 1;
            if(next >= 0 && next < 100001 && !v[next] && dist[next] > minDist + 1) {
                dist[next] = minDist + 1;
                q.add(new Node(next, dist[next]));
            }

            // 앞으로 가는 경우
            next = minIdx + 1;
            if(next >= 0 && next < 100001 && !v[next] && dist[next] > minDist + 1) {
                dist[next] = minDist + 1;
                q.add(new Node(next, dist[next]));
            }
            // 2배 앞으로 가는 경우
            next = minIdx * 2;
            if(next>=0 && next<100001 && !v[next] && dist[next] > minDist) {
                dist[next] = minDist;
                q.add(new Node(next, dist[next]));
            }
        }



    }
}
