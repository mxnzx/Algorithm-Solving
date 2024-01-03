package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2805_나무자르기 {
    static int M, N;
    static int[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());   // 가져가려는 나무 길이
        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        /*
        나무들 정렬한 다음, 파라메트릭 서치를 통해 시간복잡도 O(logN) 으로 답을 찾아낼 수 있다.
        바이너리 서치(이분탐색)는 값이 있나를 찾는문제고,
        파라메트릭 서치(매개변수탐색)는 범위를 만족하냐의 차이로 알고 있는데 반씩 나눠 탐색했으니 얼추 비슷함.
        그리고 변수 범위 잘 보고, int 쓸지 double쓸지 잘 확인하자 ..
         */
        Arrays.sort(trees);
        double sum;
        int left = 0, right = trees[N-1];
        int mid = (left + right) / 2;
        while(left<mid) {
            sum = 0;
            for (int i = N-1; i >= 0; i--) {
                if(trees[i] <= mid) break;
                sum += trees[i] - mid;
            }
            if(sum > M) {
                left = mid;
            } else if (sum == M) {
                break;
            } else {
                right = mid;
            }
            mid = (left + right) / 2;
        }
        System.out.println(mid);
    }
}
