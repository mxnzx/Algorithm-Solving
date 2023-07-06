package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17276_배열돌리기 {
    static int T, n, d;
    static int[][] input;
    static class Point {
        int r,c,val;

        public Point(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());   //시계방향기준 45,90,135,180,225,270,315,360
            if(d<=0)    d+=360;
            d /= 45;    //d=1~8
            System.out.println("d: "+ d);
            input = new int[n+1][n+1];  // 인덱스 1부터
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    input[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int r = n/2+1, c = n/2+1;   //중앙 좌표 (r,c)
            int changeArr[];
            Point pointArr[];
            for (int i = 1; i <= n/2; i++) {  //5면 2번
                //배열을 만들어서 담고, d에 따라 시작위치를 거기로 맞춘다.
                changeArr = new int[]{input[r-i][c-i], input[r-i][c], input[r-i][c+i], input[r][c+i], input[r+i][c+i], input[r+i][c], input[r+i][c-i], input[r][c-i]};
                System.out.println(Arrays.toString(changeArr));
                input[r-i][c-i] = (0-d<0) ? changeArr[8-d] :changeArr[0-d];
                input[r-i][c] = (1-d<0) ? changeArr[9-d] :changeArr[1-d];
                input[r-i][c+i] = (2-d<0) ? changeArr[10-d] :changeArr[2-d];
                input[r][c+i] = (3-d<0) ? changeArr[11-d] :changeArr[3-d];
                input[r+i][c+i] = (4-d<0) ? changeArr[12-d] :changeArr[4-d];
                input[r+i][c] = (5-d<0) ? changeArr[13-d] :changeArr[5-d];
                input[r+i][c-i] = (6-d<0) ? changeArr[14-d] :changeArr[6-d];
                input[r][c-i] = (7-d<0) ? changeArr[15-d] :changeArr[7-d];
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    sb.append(input[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}