package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2211_네트워크복구 {
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
    static ArrayList<Node>[] computer;
    static int[] dist;
    static int[] before;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        computer = new ArrayList[N + 1];
        before = new int[N+1];    //idx: 본인 val: 본인 이전 방문 노드
        for (int i = 1; i <= N; i++) {
            computer[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            computer[A].add(new Node(B, C));
            computer[B].add(new Node(A, C));
        }
        // 1. 1번 컴퓨터에서 각 노드까지 가는 최소 거리를 구하는데 + 간선 최소화 . - 다익스트라
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        dijkstra(1);

        // 내가 지나온 간선을 알아햐 한다: before 배열
        Set<String> answerSet = new HashSet<>();
        for (int i = 2; i <= N; i++) {
            int target = i;
            int prev;
            while((prev = before[target]) != 0) {
                answerSet.add(target + " " + prev);
                target = prev;
            }
        }
        StringBuilder answer = new StringBuilder();
        answer.append(answerSet.size()).append("\n");
        for(String s : answerSet) {
            answer.append(s).append("\n");
        }
        System.out.println(answer);
    }

    private static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::getWeight));

        boolean[] visited= new boolean[N+1];

        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            visited[cur.to] = true;

            for (Node next : computer[cur.to]) {
                if(!visited[next.to] && dist[next.to] > dist[cur.to] + next.weight) {
                    dist[next.to] = dist[cur.to] + next.weight;
                    pq.add(new Node(next.to, dist[next.to]));
                    before[next.to] = cur.to;
                }
            }
        }
    }
}
