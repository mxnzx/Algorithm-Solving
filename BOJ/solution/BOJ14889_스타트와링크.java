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
    static int N;
    static int[][] power;
    static int answer = Integer.MAX_VALUE;
    static boolean[] dividedTeam;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        power = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                power[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 두 팀의 능력치를 각각 더하고, 그 두 팀의 능력치의 최솟값을 구한다, => 완탐
        // 6명이라고 했을 때 3 3 나눠야함. 어캐 나눌래? -> 부분 집합, 중복순열
        // true false 로 나눠놓고, 더한다
        dividedTeam = new boolean[N];
        dividedTeam[0] = true;  //첫번째를 무조건 1번팀에 속한다고 해놓고 시작한다.(계산을 반으로 줄이기 위함)
        divideTeam(1, 1);
        System.out.println(answer);
    }

    private static void divideTeam(int pick, int idx) {

        if (pick == N / 2) {
            sumPowerByTeam();
            //System.out.println(Arrays.toString(dividedTeam));
            return;
        }

        if (idx == N) return;

        //뽑은 경우
        dividedTeam[idx] = true;
        divideTeam(pick + 1, idx + 1);
        //뽑지 않은 경우
        dividedTeam[idx] = false;
        divideTeam(pick, idx + 1);

    }

    private static void sumPowerByTeam() {
        int team1 = 0, team2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (dividedTeam[i] && dividedTeam[j]) team1 += power[i][j];
                if (!dividedTeam[i] && !dividedTeam[j]) team2 += power[i][j];
            }
        }
        answer = Math.min(Math.abs(team1 - team2), answer);
    }
}
