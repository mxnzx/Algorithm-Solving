/*
 * BOJ11659. 구간 합 구하기 4
 * 누적 합 배열을 만들어 점화식 이용
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11659_2 {
    static int N,M;
    static int[] prefixSum;
    static int start, end;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        prefixSum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            //0번 idx에는 0을 넣어주고, 인덱스1번부터 받아오는 값을 더한 누적값들을 저장한 배열을 만든다.
            prefixSum[i] += prefixSum[i-1]+Integer.parseInt(st.nextToken());
        }
        //System.out.println(Arrays.toString(prefixSum));
        for (int i = 0; i < M; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            //start~end 사이의 합은 prefixSum[end]-prefixSum[start-1]과 같다.
            sum = prefixSum[end]-prefixSum[start-1];
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

}
