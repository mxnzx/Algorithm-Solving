package solution;

import java.util.*;
import java.io.*;

public class BOJ1719_택배 {
    static class Node {
        int to;
        int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        int getWeight() {
            return weight;
        }
    }

    static int N, M;
    static List<Node>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder ans = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjList[from].add(new Node(to, weight));
            adjList[to].add(new Node(from, weight));

        }
        // 각 집하장에서 1~n번째 집하장까지의 최단경로를 가려면 처음에 이동해야 하는 집하장 번호
        for (int i = 1; i <= N; i++) {
            int[] route = dijkstra(i);
            for (int j = 1; j <= N; j++) {
                if(i == j) {
                    ans.append("-").append(" ");
                    continue;
                }

                int prev;
                int idx = j;
                while(true) {
                    prev = route[idx];

                    if(prev == i) {
                        ans.append(idx).append(" ");
                        break;
                    }
                    idx = prev;
                }
            }
            ans.append("\n");
        }
        System.out.println(ans);
    }

    private static int[] dijkstra(int from) {
        int[] dist = new int[N + 1];
        int[] prev = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::getWeight));

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[from] = 0;
        pq.add(new Node(from, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            visited[now.to] = true;

            for (Node next : adjList[now.to]) {
                if (!visited[next.to] && dist[next.to] > next.weight + dist[now.to]) {
                    dist[next.to] = next.weight + dist[now.to];
                    pq.add(new Node(next.to, dist[next.to]));
                    prev[next.to] = now.to;
                }
            }
        }

        return prev;
    }
}
