package solution;

import java.util.*;
import java.io.*;

public class BOJ12015_가장긴증가하는부분수열2 {

    static int binarySearch(int[] LIS, int val, int e) {
        int lo = 0;
        int hi = e;

        while(lo < hi) {
            int mid = (lo + hi) / 2;
            if(LIS[mid] < val) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return hi;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int[] LIS = new int[N];
        int idxLIS = 0;
        // 입력값이 10^6 이중반복문은 시간초과 발생
        // LIS의 '길이'를 구하는 문제이고, 따라서 실제 수열값을 찾을 필요가 없기 때문에 이분탐색을 사용한다.
        LIS[0] = seq[0];
        for (int i = 1; i < N; i++) {
            int val = seq[i];
            // 현재 탐색값이 가장 큰 값보다 크면 추가
            if(val > LIS[idxLIS]) {
                LIS[++idxLIS] = val;
            } else { // 그렇지 않으면 탐색값보다 큰 값 중에 가장 작은 값을 찾아 대치
                int idx = binarySearch(LIS, val, idxLIS);
                LIS[idx] = val;
            }
        }

        System.out.println(idxLIS+1);
    }
}
