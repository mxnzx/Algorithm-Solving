/*
 * [SWEA]9229. 한빈이의 Spot Mart
 * 그리디
 * 막힌 부분: 조합 메소드 잘못 짬. 선택 다 안했는데 배열 다돌았을 경우 코드
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA9229_SpotMart {
    static int T, N, M, Ans;
    static int[] snack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            snack = new int[N];
            Ans = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                snack[i] = Integer.parseInt(st.nextToken());
            }
            //과자를 두개를 골라 M그램과 최대한 맞춰 출력 안되면 -1
            //그리디. 웬만하면 완탐. M-과자두개를 골라 뺐을때(조합) 차이가 가장 적은거
            comb(new int[2],0,0);

            if(Ans == Integer.MAX_VALUE) {
                Ans = -1;
            } else {
                Ans = M - Ans;
            }

            sb.append("#").append(tc).append(" ").append(Ans).append("\n");
        }
        System.out.println(sb);

        br.close();

    }

    private static void comb(int[] sel, int idx, int k) {
        //2개 뽑았을 때
        if(k == 2) {
            int tmp = M-sel[0]-sel[1];

            if (tmp < 0) return;
            //차가 0보다 크면 최솟값 비교해서 갱신
            Ans = Math.min(Ans, tmp);
            return;
        }
        //다 못뽑았는데 돌았을 때
        if(idx == snack.length) return;

        //고를 경우
        sel[k] = snack[idx];
        comb(sel, idx+1, k+1);
        //안고를경우
        comb(sel, idx+1,k);




    }
}
