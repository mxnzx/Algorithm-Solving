/*
 * [BOJ]2606.바이러스
 * 놓친 부분: 완탐(dfs)는 시간초과에 유의.
 * bfs로 풀수 있으면 그렇게 먼저 풀어보자. 대신 놓치는 부분 없난 확인 잘 할것. 조건을 따로 주지않으면 bfs도 다 돌긴 돔. 대신 시간 빠름
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2606_바이러스 {
    static int V,E;
    static ArrayList<Integer>[] adjList;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        v = new boolean[V + 1];
        adjList = new ArrayList[V + 1];   //1번부터 사용
        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from, to;
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }
        System.out.println(bfs());
    }
    private static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        v[1] = true;

        while (!q.isEmpty()) {
            int p = q.poll();
            for(int next:adjList[p]) {
                if(!v[next]) {
                    v[next] = true;
                    q.add(next);
                }
            }
        }
        int cnt=0;
        for(boolean v:v) {
            if(v) cnt++;
        }
        return cnt-1;   //맨처음 1카운팅한거 제외
    }


}
