/*
 * [BOJ]18352. 특정거리도시찾기
 * 다익스트라
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18352_특정거리도시찾기 {
    static int N,M,K,X;
    static ArrayList<Integer>[] adjList;
    static boolean[] v;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   //도시개수
        M = Integer.parseInt(st.nextToken());   //도로개수(간선수)
        K = Integer.parseInt(st.nextToken());   //주어진 최단거리
        X = Integer.parseInt(st.nextToken());   //출발도시번호
        v = new boolean[N+1];
        dist = new int[N+1];
        //인접 리스트 생성
        adjList = new ArrayList[N+1];
        for (int i = 1; i <= N ; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            adjList[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        //다익스트라
        Arrays.fill(dist, -1);  //어차피 거리가 다 1이므로
        dist[X]=0;  //시작점의 거리를 0으로 잡는다
        Queue<Integer> q = new LinkedList<>();
        q.add(X);
        while (!q.isEmpty()) {
            int p = q.poll();
            for(int next : adjList[p]) {
                if(dist[next] == -1) {  //안간부분만 간다.
                    dist[next] = dist[p] + 1;
                    q.add(next);
                }
            }
        }

        boolean flag = false;    //정답이 있는지 확인할 플래그
        for (int i = 1; i <= N; i++) {
            if(dist[i] == K) {
                sb.append(i).append("\n");
                flag = true;
            }
        }
        if(flag) System.out.println(sb);
        else System.out.println(-1);

    }
}
