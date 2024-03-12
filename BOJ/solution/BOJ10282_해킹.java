package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ10282_해킹 {

    static class Node {
        int node;
        int weight;

        Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        int getWeight() {
            return weight;
        }
    }

    static int n, d, c;
    static List<Node>[] adjList;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());    //컴퓨터 개수
            d = Integer.parseInt(st.nextToken());    //의존성 개수
            c = Integer.parseInt(st.nextToken());    //해킹당한 컴퓨터 번호
            adjList = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                adjList[i] = new ArrayList<>();
            }
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                adjList[b].add(new Node(a, s));
            }
            int[] dist = dijkstra();
            int cnt = 0;
            int max = -1;
            for(int n : dist) {
                if(n!=INF) {
                    cnt++;
                    max = Math.max(max, n);
                }
            }
            answer.append(cnt).append(" ").append(max).append("\n");
        }
        System.out.println(answer);
    }

    private static int[] dijkstra() {
        // 1. 거리 배열을 무한대로 초기화
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        // 2. 시작정점 - 0으로 둔다
        dist[c] = 0;
        //3. 방문배열 필요
        boolean[] visited = new boolean[n+1];
        // 4. 우선순위큐를 사용한다(최대힙)
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::getWeight));
        pq.add(new Node(c, 0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            visited[current.node] = true;
            // 5. 현재 정점과 인접한 노드를 돌면서 최소거리배열의 값을 갱신한다.
            for(Node next: adjList[current.node]) {
                if(!visited[next.node] && dist[next.node] > dist[current.node] + next.weight){
                    dist[next.node] = dist[current.node] + next.weight;
                    pq.add(new Node(next.node, dist[next.node]));
                }
            }
        }
        return dist;
    }
}
