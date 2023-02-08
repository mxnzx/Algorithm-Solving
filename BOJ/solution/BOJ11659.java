/*
 * BOJ11659. 구간 합 구하기 4
 * 재귀 코드 - 시간초과
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11659 {
    static int N,M;
    static int[] num;
    static int start, end;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());

        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            prefixSum(start, 0);
        }

        System.out.println(sb);
//        br.close();
    }
    private static void prefixSum(int idx, int sum) {

        if(idx > end) {
            sb.append(sum).append("\n");
            return;
        }
        sum += num[idx];
        prefixSum(idx+1,sum);
    }
}
