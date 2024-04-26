package solution;

import java.io.*;
import java.util.*;

public class BOJ2252_줄세우기 {

    static int n, m;
    static ArrayList<Integer>[] graph;
    static int[] edgeCnt;
    static StringBuilder ans = new StringBuilder();

    static boolean topologicalSort() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if(edgeCnt[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            int now = q.poll();
            ans.append(now).append(" ");
            for(int next : graph[now]) {
                edgeCnt[next]--;
                if(edgeCnt[next] == 0) q.add(next);
            }
        }

        for (int i = 1; i <= n; i++) {
            if(edgeCnt[i] > 0) return false;
        }

        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        edgeCnt = new int[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());
            graph[front].add(back);
            edgeCnt[back]++;
        }
        if(topologicalSort()) System.out.println(ans);
    }
}
