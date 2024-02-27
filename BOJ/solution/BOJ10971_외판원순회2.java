package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10971_외판원순회2 {

    static int N, min;
    static int[][] adjArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        adjArr = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                adjArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            recursive(new boolean[N+1], i, i, 0);
        }
        System.out.println(min);

    }

    private static void recursive(boolean[] visited, int start, int now, int sum) {

        if(visited[start] && now == start) {
            for (int i = 1; i <= N; i++) {
                if(!visited[i]) return;
            }
            min = Math.min(min, sum);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(adjArr[now][i] > 0 && !visited[i]) {
                visited[i] = true;
                recursive(visited, start, i, sum+adjArr[now][i]);
                visited[i] = false;
            }
        }
    }
}
