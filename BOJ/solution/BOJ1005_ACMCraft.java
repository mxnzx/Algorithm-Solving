package solution;

import java.util.*;
import java.io.*;

/*
1. bfs: 메모리 초과
2. 위상정렬: 선후관계가 명확한 비순환 그래프이므로 위상 정렬을 통해 O(V+E)로 값을 구해낼 수 있다.
 */
public class BOJ1005_ACMCraft {

    static int[] time;
    static int[] maxTime;
    static int[] edgeCnt;
    static ArrayList<Integer>[] graph;

    static void topologicalSort(int target) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < time.length; i++) {
            if(edgeCnt[i] == 0) q.add(i);
        }

        while(!q.isEmpty()) {
            int now = q.poll();
            if(now == target) continue;

            for(int next : graph[now]) {
                edgeCnt[next]--;
                if(edgeCnt[next] == 0) q.add(next);
                maxTime[next] = Math.max(maxTime[now] + time[next], maxTime[next]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder ans = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            time = new int[n+1];
            maxTime = new int[n+1];
            edgeCnt = new int[n+1];
            graph = new ArrayList[n+1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                time[i] = Integer.parseInt(st.nextToken());
                maxTime[i] = time[i];
            }
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x].add(y);
                edgeCnt[y]++;
            }
            int w = Integer.parseInt(br.readLine());
            topologicalSort(w);

            ans.append(maxTime[w]).append("\n");
        }
        System.out.println(ans);
    }
}