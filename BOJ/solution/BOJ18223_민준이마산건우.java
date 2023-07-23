package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18223_민준이마산건우 {
    static class Node {
        int node, weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }
    static int V,E,P;
    static ArrayList<Node>[] adjList;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());   //건우위치
        adjList = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }

        int node1, node2, cost;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            node1 = Integer.parseInt(st.nextToken());
            node2 = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            adjList[node1].add(new Node(node2, cost));
            adjList[node2].add(new Node(node1, cost));
        }
        //다익스트라
        int normal = Dijkstra(false, 1);
        int included = Dijkstra(true,1) + Dijkstra(false,P);
        String result = (included <= normal) ? "SAVE HIM" : "GOOD BYE";
        System.out.println(result);
    }

    private static int Dijkstra(boolean isInclude, int start) {
        //거리 배열 무한대로 초기화
        dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;    //출발 정점

        visited = new boolean[V+1];

        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(Node::getWeight));
        q.add(new Node(start,dist[start]));

        int minIdx, minDist;
        while(!q.isEmpty()) {
            Node present = q.poll();
            minIdx = present.node;
            minDist = present.weight;
            visited[present.node] = true;

            if(isInclude && minIdx == P) break; //건우포함상황에, 건우가 있는 곳까지 왔으면 탈출한다
            if(!isInclude && minIdx == V) break;    //건우 미포함 상황에, 정점 도착하면 탈출
            for(Node next : adjList[minIdx]) {
                if(!visited[next.node] && dist[next.node] >= next.weight + minDist) {
                    dist[next.node] = next.weight + minDist;
                    q.add(new Node(next.node, dist[next.node]));
                }
            }
        }
        return isInclude ? dist[P] : dist[V];
    }
}