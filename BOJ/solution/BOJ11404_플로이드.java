package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11404_플로이드 {
    static int[][] dist;
    static int INF = 100_000_000;   //가장 큰 값보다 더 큰값(MAX_VALUE로 잡아놓으면 오버플로우때문에 음수로 바뀌니 주의)
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        int n = Integer.parseInt(br.readLine());    //노드 개수
        int m = Integer.parseInt(br.readLine());    //간선 개수
        //0. 인접행렬 생성
        dist = new int[n+1][n+1];
        //1. 자기 자신은 0으로 두고 INF로 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j) continue;
                dist[i][j] = INF;
            }
        }
        int start, dest, cost;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            dest = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            //2. 간선의 비용을 넣어준다.
            dist[start][dest] = Math.min(dist[start][dest], cost);
        }
        //3. 모든 경우를 탐색. dp을 이용해 계산해주어야 하고, N개의 노드를거쳐서 가는 경우를 차례로 고려한다.
        floyd_warshall(n);

        int ans;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j || dist[i][j] == INF) ans = 0;
                else ans = dist[i][j];
                sb.append(ans).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void floyd_warshall(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                }
            }
        }
    }
}
