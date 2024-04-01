package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11779_최소비용구하기2 {
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

    static int n, m;
    static List<Node>[] bus;
    static int[] dist, before;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        bus = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            bus[i] = new ArrayList<>();
        }
        m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            bus[s].add(new Node(e, w));
        }
        st = new StringTokenizer(br.readLine());
        int departure = Integer.parseInt(st.nextToken());
        int arrival = Integer.parseInt(st.nextToken());
        // 특정 거리의 최솟값 + 양의 가중치 = 다익스트라
        dijkstra(departure, arrival);
        //역추적 및 출력
        int cnt = 1;
        int now = before[arrival];
        Stack<Integer> city = new Stack<>();
        city.push(arrival);
        while(!(now == 0)) {
            city.push(now);
            cnt++;
            now = before[now];
        }
        StringBuilder answer = new StringBuilder();
        answer.append(dist[arrival]).append("\n");
        answer.append(cnt).append("\n");
        while (!city.empty()){
            answer.append(city.pop()).append(" ");
        }
        System.out.println(answer);
    }
    private static void dijkstra(int departure, int arrival) {
        dist = new int[n + 1];
        before = new int[n+1];    // 역추적을 위한 이전 도시 배열
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[departure] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(Node::getWeight));
        q.add(new Node(departure, 0));

        while (!q.isEmpty()) {
            Node current = q.poll();
            visited[current.node] = true;

            if(current.node == arrival) break;

            for (Node next : bus[current.node]) {
                if(!visited[next.node] && dist[next.node] > dist[current.node] + next.weight) {
                    dist[next.node] = dist[current.node] + next.weight;
                    before[next.node] = current.node;
                    q.add(new Node(next.node, dist[next.node]));
                }
            }
        }
    }
}
