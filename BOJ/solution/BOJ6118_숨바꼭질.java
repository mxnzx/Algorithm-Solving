/*
 * [BOJ]6118. 숨바꼭질
 * BFS(다익스트라 코드느낌의)
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ6118_숨바꼭질 {

    static int N,M;
    static ArrayList<Integer>[] adjList;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   //헛간 개수(인덱스 1부터)
        M = Integer.parseInt(st.nextToken());   //길의 개수

        //인접리스트 구현.
        adjList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        //그래프는 양방향이고, 가중치 X - BFS
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from, to;
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }
        //BFS
        dist = new int[N+1];
        Arrays.fill(dist, -1);
        dist[1] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {
            int p = q.poll();

            for(int next : adjList[p]) {
                if (dist[next] == -1) {
                    dist[next] = dist[p] + 1;
                    q.add(next);
                }
            }
        }
        //가장 큰 값의 인덱스와 그 값을 찾고, 값이 여러개이면 그 개수를 센다
        int maxIdx = 0;
        int maxVal = Integer.MIN_VALUE;
        int cnt = 0;    //같은 거리를 가지고 있는 헛간 개수 카운팅 변수
        for (int i = 1; i <= N; i++) {
            if(dist[i] > maxVal) {
                maxIdx = i;
                maxVal = dist[i];
            }
        }
        for (int i = 1; i <= N; i++) {
            if(maxVal == dist[i]) cnt++;
        }
        sb.append(maxIdx).append(" ").append(maxVal).append(" ").append(cnt);
        System.out.println(sb);



    }
}
