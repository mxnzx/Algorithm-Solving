package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1449_수리공항승 {
    static int N, L;
    static int[] pos;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        pos = new int[1001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pos[Integer.parseInt(st.nextToken())]++;
        }
        /*
        0 1100000....11.....
        돌다가 1이나오면 0 1  1 1 1 1 0 이 나오면
         */
        int n=1;
        int needCnt = 0;
        while(n < 1001) {
            if(pos[n] < 1) continue;
            int end = counting(n,n+1);
            //n이 시작이고, end가 끝이므로 거리 계산
            int length = end - n;
            if(length < N) {
                needCnt +=1;
                n = end;
                continue;
            }
            needCnt = length / 2; //3/2=1

        }

    }
    private static int counting(int start, int n) {
        if(pos[n] == 1 && n <= 1000) counting(start, n+1);
        else return n-1;
    }
}
