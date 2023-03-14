package solution;
/*
 * BOJ5972_택배배송
 * 다익스트라
 * 실수한 부분: 방문배열을 큐에 넣어줄 때 하게되면, 아직 가보지도 않고 방문처리가 된다. 생각하면서 코드 짜자.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ5972_택배배송 {
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
    static int N,M, INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] adjList;
    static boolean[] v;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //헛간
        M = Integer.parseInt(st.nextToken()); //길

        dist = new int[N+1];
        v = new boolean[N+1];
        //인접리스트 생성
        adjList = new ArrayList[N+1];   //1번~
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int from,to,w;
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            adjList[from].add(new Node(to,w));
            adjList[to].add(new Node(from,w));
        }

        //다익스트라 실행
        Arrays.fill(dist, INF);
        dist[1]=0;
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(Node::getC));
        q.add(new Node(1,0));

        while (!q.isEmpty()) {
            Node p = q.poll();
            //시작 정점
            int minIdx = p.e;
            int minDist = p.c;
            v[minIdx]=true;
            System.out.println(Arrays.toString(v));

            if(minIdx == N) {
                System.out.println(minDist);
                break;
            }

            for(Node next:adjList[minIdx]) {
                if(!v[next.e] && dist[next.e] > minDist + next.c) {
                    dist[next.e] = minDist + next.c;
                    q.add(new Node(next.e,dist[next.e]));
                }
            }
        }

    }
}
