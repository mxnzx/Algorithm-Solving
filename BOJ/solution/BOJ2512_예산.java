package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2512_예산 {
    static int N, M;
    static int[] reqBudgets;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        reqBudgets = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            reqBudgets[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        /*
        최적화 문제를 결정문제로 바꾸어 푼다. 파라메트릭 서치 알고리즘 사용.
        값이 21억을 초과할 가능성이 있으므로 long 타입을 사용한다 -> 없다. int 로 해도 됨. 10^4 * 10^5 최대
         */
        Arrays.sort(reqBudgets);
        int start=M/N, end = reqBudgets[N-1], mid=(start+end) / 2, sum;
        while(start<=end) {
            sum = 0;
            System.out.println(start + " " + mid + " " + end);
            for (int i = 0; i < N; i++) {
                if(reqBudgets[i] <= mid) sum += reqBudgets[i];
                else sum += mid;
                if(sum > M) break;
            }
            System.out.println(sum);
            if(sum > M) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        System.out.println(mid);
    }
}
