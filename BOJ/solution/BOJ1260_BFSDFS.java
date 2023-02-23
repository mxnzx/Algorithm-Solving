/*
 * [BOJ]1260. BFS와 DFS
 * 그래프의 BFS, DFS 탐색 - 인접행렬로 구현
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260_BFSDFS {
    static StringBuilder sb = new StringBuilder();
    static int N, M, V;
    static int[][] adjMatrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  //정점 개수
        M = Integer.parseInt(st.nextToken());  //간선 개수
        V = Integer.parseInt(st.nextToken());  //시작 정점

        //인접행렬로 구현하기
        adjMatrix = new int[N+1][N+1];  //1부터 받았다
        int from, to;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            adjMatrix[from][to] = adjMatrix[to][from] = 1;
        }


        dfs(V, new boolean[N+1]);
        System.out.println();
        bfs();

    }
    //p:현재 정점
    private static void dfs(int p, boolean[] v) {

        v[p]=true;

        System.out.print(p + " ");

        for (int i = 1; i <= N; i++) {

            if(adjMatrix[p][i] == 1 && !v[i]) {
                dfs(i,v);
            }
        }
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[N+1];
        q.offer(V);
        v[V] = true;


        while (!q.isEmpty()) {
            int p = q.poll();
            System.out.print(p + " ");

            //인덱스 1부터
            for (int i = 1; i <= N; i++) {
                if (adjMatrix[p][i] == 1 && !v[i]) {
                    q.offer(i);
                    v[i] = true;
                }

            }
        }
    }
}