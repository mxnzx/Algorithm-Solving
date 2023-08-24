package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1388_바닥장식 {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j]) {
                    dfs(i,j);
                    result++;
                }

            }
        }
        System.out.println(result);
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;

        if(map[i][j] == '|') {
            i++;
            if(i<N && map[i][j] == '|' && !visited[i][j]) dfs(i,j);
        } else {
            j++;
            if(j<M && map[i][j] == '-' && !visited[i][j]) dfs(i,j);
        }

    }
}
