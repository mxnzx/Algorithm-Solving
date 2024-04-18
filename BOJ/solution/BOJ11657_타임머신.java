package solution;

import java.io.*;
import java.util.*;

public class BOJ11657_타임머신 {
    static class Node {
        int e, w;

        Node(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }

    static int N, M;
    static long[] dist;
    static List<Node>[] bus;
    static final int INF = Integer.MAX_VALUE;

    private static boolean bellmanFord(int start) {
        dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        // 벨만-포드: 매 단계마다 모든 간선을 전부 확인하면서 노드 간 최단거리를 구한다
        // 정점 개수 N개, 최단거리로 갈 수 있는 간선은 최대 N-1개이다. N-1번을 반복하며 갱신한다.
        for (int i = 0; i < N - 1; i++) {
            for (int j = 1; j <= N; j++) {
                if(dist[j] == INF) continue;
                for (Node next : bus[j]) {
                    if(dist[next.e] > dist[j] + next.w) {
                        dist[next.e] = dist[j] + next.w;
                    }
                }
            }
        }

        // 한번 더 수행했을 때 테이블 갱신되면 true
        for (int i = 1; i <= N; i++) {
            for (Node next : bus[i]) {
                if(dist[next.e] != INF && dist[next.e] > dist[i] + next.w) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        bus = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            bus[i] = new ArrayList<>();
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            bus[s].add(new Node(e, w));
        }

        if (bellmanFord(1)) {
            System.out.println(-1);
            return;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            if (dist[i] == INF) {
                ans.append(-1).append("\n");
            } else {
                ans.append(dist[i]).append("\n");
            }
        }
        System.out.println(ans);
    }
}