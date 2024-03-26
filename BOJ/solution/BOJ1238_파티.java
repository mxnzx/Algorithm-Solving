package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1238_파티 {
    static class Node {
        int node;
        int weight;
        Node(int node, int weight) {
            this.node= node;
            this.weight= weight;
        }
        int getWeight() {
            return weight;
        }
    }
    static int N, M, X;
    static ArrayList<Node>[] adjList, reverseAdjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N+1];
        reverseAdjList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
            reverseAdjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList[start].add(new Node(end, w));
            reverseAdjList[end].add(new Node(start, w));
        }
        //입력값을 반대로 받아, X~i로 한번만 다익스트라를 수행하도록 하면 반복할 필요가 없다
        int[] backDist = dijkstra(adjList);
        int[] goDist = dijkstra(reverseAdjList);

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, backDist[i] + goDist[i]);
        }

        System.out.println(answer);
    }

    private static int[] dijkstra(ArrayList<Node>[] adjList) {
        int[] dist = new int[N+1];
        boolean[] visited = new boolean[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::getWeight));
        pq.add(new Node(X, 0));
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            visited[current.node] = true;

            for(Node next: adjList[current.node]) {
                if(!visited[next.node] && dist[next.node] > dist[current.node] + next.weight) {
                    dist[next.node] = dist[current.node] + next.weight;
                    pq.add(new Node(next.node, dist[next.node]));
                }
            }
        }
        return dist;
    }
}
