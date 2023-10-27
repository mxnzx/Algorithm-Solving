package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11403_경로찾기 {
    static int N;
    static int[][] ansMatrix;
    static ArrayList<Integer>[] adjLists;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        ansMatrix = new int[N][N];
        adjLists = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n == 1) adjLists[i].add(j);
            }
        }

        // 1부터 지나면서 연결이 되어 있으면 ansMatrix에 1로 체크한다
        // ansMatrix가 이미 1이면 넘어간다
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            bfs(i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(ansMatrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int present = q.poll();
            for (int next : adjLists[present]) {
                    ansMatrix[start][next] = 1;
                    if(!visited[next])  {
                        q.add(next);
                        visited[next] = true;
                }
            }
        }
    }
}
