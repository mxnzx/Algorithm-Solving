package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10709_기상캐스터 {

    static int H, W;
    static char[][] map;
    static int[][] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new char[H+1][W+1];
        for (int i = 1; i <= H; i++) {
            String input = br.readLine();
            for (int j = 1; j <= W; j++) {
                map[i][j] = input.charAt(j-1);
            }
        }
        time = new int[H+1][W+1];
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {

                if(map[i][j] == 'c') {
                    time[i][j] = 0;
                    continue;
                }

                boolean isComeCloud = false;
                int nowTime = 0;
                for (int k = j - 1; k > 0; k--) {
                    nowTime++;
                    if(map[i][k] == 'c') {
                        time[i][j] = nowTime;
                        isComeCloud = true;
                        break;
                    }
                }
                if(!isComeCloud) time[i][j] = -1;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                ans.append(time[i][j]).append(" ");
            }
            ans.append("\n");
        }
        System.out.println(ans);
    }
}
