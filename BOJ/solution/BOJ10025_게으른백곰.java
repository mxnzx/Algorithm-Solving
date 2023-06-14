// 슬라이딩 윈도우: 윈도우 크기에 주의하자

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10025_게으른백곰 {
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //크기가 고정적 : K
        //배열안의 연속적인 수의 합을 구함
        // 슬라이딩 윈도우
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[1000001];
        int gram, pos, maxPos=0;
        int totalSum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            gram = Integer.parseInt(st.nextToken());
            pos = Integer.parseInt(st.nextToken());
            arr[pos] = gram;
            maxPos = Math.max(maxPos, pos);
            totalSum += gram;
        }
        int size = 2*K+1;
        if(size > arr.length) {     //전체 합 내놓고 바로 종료
            System.out.println(totalSum);
            System.exit(0);
        }
        int sum=0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
        }
        int max = sum;
        int start = 0;
        int end = size;
        while(end<=maxPos) {
            sum = sum - arr[start] + arr[end];
            max = Math.max(max, sum);
            start++;
            end++;
        }
        System.out.println(max);
    }
}
