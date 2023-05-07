// 경우의 수가 여러가지 있는 것을 뽑아야 하므로 큐에 넣을 때 방문처리하면 그 다음 것이 나올 수 없음
// poll할 때 방문처리를 해야 한다

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ12851_숨바꼭질2 {
    static class Node {
        int node, cnt;

        public Node(int node, int cnt) {
            this.node = node;
            this.cnt = cnt;
        }
    }
    static int[] dist;
    static boolean[] v;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());   //동생

        dist = new int[100001];
        v = new boolean[100001];

        bfs();

    }
    private static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N, 0));

        int totalCnt = 0;
        boolean isFirst = true;
        int res=0;

        while(!q.isEmpty()) {
            Node p = q.poll();
            v[p.node] = true;
            if(p.node == K) {
                if(isFirst)  {
                    res = p.cnt;
                    isFirst = false;
                }
                if(res == p.cnt) totalCnt++;
            }

            //x-1 일때
            int next = p.node - 1;
            if(next>=0 && !v[next]) {
                q.add(new Node(next, p.cnt + 1));
            }
            //x+1 일때
            next = p.node + 1;
            if(next <= 100000 && !v[next]) {
                q.add(new Node(next, p.cnt+1));
            }
            //2*x 일때
            next = p.node * 2;
            if(next <= 100000 && !v[next]) {
                q.add(new Node(next, p.cnt + 1));
            }
        }
        System.out.println(res);
        System.out.println(totalCnt);
    }
}
