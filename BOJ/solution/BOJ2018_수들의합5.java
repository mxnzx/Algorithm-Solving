package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2018_수들의합5 {
    static int N, start, end, sum, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 투포인터
        //1 2 3 4 5 6 7 8 9 10
        // sum=N이 나올때마다 카운트(cnt++)
        // sum<N 이면 end++
        // 아니면 start++

        start=1;
        end=1;
        sum=1;

        while(true) {
            if (sum == N) cnt++;

            //기저조건
            if (start == end && start == N) break;

            if (sum < N) {
                end++;          //끝점 다음칸으로 이동시키고 합을 더한다
                sum += end;
            } else {
                sum -= start;   //시작점을 다음칸으로 이동시키는데, 먼저 현재start 빼고나서  start 증가 시킨다
                start++;
            }
        }
        System.out.println(cnt);
    }
}
