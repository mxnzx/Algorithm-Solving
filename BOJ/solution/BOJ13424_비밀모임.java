package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ13424_비밀모임 {
    static int T, N, M, K; //양방향 그래프
    static class Node {
        int node;
        int weight;
        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }
    static ArrayList[] adjList;
    static int[] presentRoomNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());   //노드 수
            M = Integer.parseInt(st.nextToken());   //간선 수
            adjList = new ArrayList[N+1];
            for (int i = 1; i <= N; i++) {
                adjList[i] = new ArrayList<>();
            }
            int s, e, w;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());
                w = Integer.parseInt(st.nextToken());
                adjList[s].add(new Node(e,w));
                adjList[e].add(new Node(s,w));
            }
            K = Integer.parseInt(br.readLine());    //모임에 참여하는 친구 수
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                presentRoomNum[i] = Integer.parseInt(st.nextToken());
            }
            // 최소의 목적지를 찾기 위해 다 가봐야 한다 -> 완전탐색
            // 같은 값이 있으면 가장 작은 방번호 출력
            // 1번방부터 하고, 더 작은 값이 나오면 갱신하도록 한다

            for (int end = 1; end <= N; end++) {
                int sum = 0;
                for (int i = 0; i < presentRoomNum.length; i++) {
                    int start = presentRoomNum[i];
                    //end까지 얼마의 비용이 걸릴건지 각 친구들마다 해서 더함
                    //다익스트라 코드
                    dijkstra(start, end);

                    //sum += dist[end];
                }
            }



        }
        System.out.println(sb);

    }
    static int[] dist;

    private static void dijkstra(int start, int end) {
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(Node::getWeight));
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;


    }
}
