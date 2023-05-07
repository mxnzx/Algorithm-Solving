//이전 경로를 담아오려면 parents 을 따로 만들어 값을 이어이어 넣고, 나중에 스택에 넣고 빼면 굳굳

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ13913_숨바꼭질4 {
    static class Node {
        int node, cnt;

        public Node(int node, int cnt) {
            this.node = node;
            this.cnt = cnt;
        }
    }
    static int[] parents;
    static boolean[] v;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());   //동생

        parents = new int[100001];
        v = new boolean[100001];

        bfs();

    }
    private static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N, 0));
        v[N] = true;

        while(!q.isEmpty()) {
            Node p = q.poll();

            //목표점에 도착했으면 값을 출력
            if(p.node == K) {
                searchPath();   //이전경로 담아오기
                System.out.println(p.cnt);
                while(!s.isEmpty())
                    System.out.print(s.pop() + " ");

                return;
            }

            //x-1 일때
            int next = p.node - 1;
            if(next>=0 && !v[next]) {
                q.add(new Node(next, p.cnt + 1));
                v[next]=true;
                parents[next] = p.node;
            }
            //x+1 일때
            next = p.node + 1;
            if(next <= 100000 && !v[next]) {
                q.add(new Node(next, p.cnt+1));
                v[next]=true;
                parents[next] = p.node;
            }
            //2*x 일때
            next = p.node * 2;
            if(next <= 100000 && !v[next]) {
                q.add(new Node(next, p.cnt + 1));
                v[next]=true;
                parents[next] = p.node;
            }
        }
    }
    static Stack<Integer> s = new Stack<>();
    private static void searchPath() {
        s.push(K);
        int next = K;
        while(true) {
            if(next == N) return;
            int before = parents[next];
            s.push(before);
            next = before;
        }
    }
}
