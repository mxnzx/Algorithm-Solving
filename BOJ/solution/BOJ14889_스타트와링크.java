/*
 * [BOJ]14889. 스타트와링크
 * 순조부(조합론) - 중복순열 -> 인덱스를 뽑는다고 생각하자
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14889_스타트와링크 {
    static int N, Ans=Integer.MAX_VALUE;
    static int[][] map; //입력 능력치
    static int[] team;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        team = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //팀인덱스 0~N-1까지 N/2로 나누어야함
        comb(0,0);

        System.out.println(Ans);
    }
    private static void comb(int idx,int k){
        if(k == N/2) {
            cal();
            return;
        }
        //인덱스의 반만 1을 넣겠다
        for (int i = idx; i < N; i++) {
            team[i]=1;
            comb(i+1,k+1);
            team[i]=0;
        }
    }

    private static void cal() {
        int team0=0, team1=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(team[i] == 0 && team[j] == 0) team0 += map[i][j];
                if(team[i] == 1 && team[j] == 1) team1 += map[i][j];
            }
        }
        Ans = Math.min(Ans, Math.abs(team0-team1));
    }
}
