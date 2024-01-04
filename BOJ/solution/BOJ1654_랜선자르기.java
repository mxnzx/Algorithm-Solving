package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1654_랜선자르기 {
    static int K, N;
    static int[] lines;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lines = new int[K];
        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }
        /*
        4 3 2 2 = 11개
        최댓값을 구하는 문제 -> 결정문제로 바꾼다
        x길이만큼 잘라서 N개를 만들어야 한다 -> x 길이라고 정했을 때 N개 만들 수 있는가 ? => 파라메트릭 서치
        x 가 될수있는 범위: 1 ~ lines[N-1]
                N의 개수: sum ~ 1
        정수 자료형.. int 다음 long 이 있다.. 왜 double만 있다고 생각했지?
         */
        Arrays.sort(lines);
        long left = 1, right = lines[K-1];
        long mid = (left + right) / 2;    // 랜선 길이
        while(left <= right) {
            long cutLineCnt = 0;
            for (int i = 0; i < K; i++) {
                cutLineCnt += lines[i] / mid;
            }
            if(cutLineCnt < N) {
                right = mid-1;
            } else {
                left = mid+1;
            }
            mid = (left + right) / 2;
        }
        System.out.println(mid);
    }
}
