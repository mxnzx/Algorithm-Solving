package solution;

import java.util.Scanner;

public class Building {
    //팔방탐색
    public static int[] dr = {-1,1,0,0,-1,-1,1,1};
    public static int[] dc = {0,0,-1,1,-1,1,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int t=1; t<=T; t++) {
            int ans=0;
            int n = sc.nextInt();
            char[][] map = new char[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.next().charAt(0);
                }
            }

            //map을 하나씩 돌면서, B이면 팔방 탐색
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    int cntB=0;
                    boolean isPark = false;

                    if(map[i][j] == 'B') {
                        for (int k = 0; k < 8; k++) {
                            int nr = i + dr[k];
                            int nc = j + dc[k];

                            //가장자리 조건
                            if((nr < 0) || (nr >= n) || (nc < 0) || (nc >= n)) continue;

                            //하나라도 G가 걸리면 탈출. 다음 칸
                            if((map[nr][nc] == 'G')){
                                isPark = true;
                                break;
                            }
                        }
                        if(!isPark) {
                            //전부 B인 경우
                            for (int k = 0; k < n; k++) {
                                if(map[i][k] == 'B') cntB++;
                                if(map[k][j] == 'B') cntB++;
                            }
                            cntB--;    //가운데 중복 하나 뺌
                        }
                        ans = Math.max(ans, cntB);
                    }
                }
            }
            //하나도 전부 B가 없을 경우
            if(ans == 0) ans=2;

            System.out.println("#" + t + " " + ans);
        }
        sc.close();
    }
}
