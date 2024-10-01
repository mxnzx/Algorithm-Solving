package solution;

import java.io.*;
import java.util.*;

public class BOJ16401_과자나눠주기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //  모든 조카에게 같은 길이의 막대 과자를 나눠주어야 한다
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 조카
        int N = Integer.parseInt(st.nextToken()); // 과자
        st = new StringTokenizer(br.readLine());
        int[] snacks = new int[N];
        for (int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(snacks);

        System.out.println(binarySearch(M, snacks, 1, snacks[N-1]));
    }

    private static int binarySearch(int M, int[] snacks, int lo, int hi) {

        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            int cnt = 0;

            for (int i = snacks.length - 1; i >= 0; i--) {
                int tmp = snacks[i] / mid;
                if(tmp == 0) break;
                cnt += tmp;
            }

            if(cnt >= M) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return hi;
    }
}
