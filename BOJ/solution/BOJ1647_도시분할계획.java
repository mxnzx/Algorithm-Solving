// MST
package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1647_도시분할계획 {

    static class Node implements Comparable<Node>{
        int from, to;
        int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
             return this.cost - o.cost;
        }
    }
    static int[] parents;
    static ArrayList<Node> edgeList;
    static int N,M;
    public static void main(String[] args) throws IOException {
        //MST -> 크루스칼
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //간선리스트 생성
        edgeList = new ArrayList<>();
        int from, to, cost;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            edgeList.add(new Node(from, to, cost));
        }

        //크루스칼 ㄱㄱ
        // MST를 만들어놓고 가장 큰 간선을 뺀 값을 구하면 유지비의 합이 최소가 되겠다(마지막을 더하지 말자)
        Collections.sort(edgeList);

        parents = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        int cnt=0; //cnt가 N-2이 될때까지
        long sum=0L;
        Node p;
        for (int i=0; i<edgeList.size() && cnt<N-2; i++) {
            p = edgeList.get(i);

            if(find(p.from) != find(p.to)) {
                union(p.from, p.to);
                sum+=p.cost;
                cnt++;
            }
        }
        System.out.println(sum);
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(pa != pb) parents[pb] = pa;
    }

    private static int find(int a) {
        if(parents[a] == a) return a;
        else return parents[a] = find(parents[a]);
    }
}
