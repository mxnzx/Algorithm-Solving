package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ19941_햄배거분배 {
    static int N, K;
    static char[] seq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        seq = new char[N];
        String input = br.readLine();
        for (int i = 0; i < N; i++) {
            seq[i] = input.charAt(i);
        }
        /*
        K 보다 가까운 햄버거를 먹을 수 있고, 최대한 많은 사람이 먹어야 한다.
        이때 먹을 수 있는 사람의 최댓값?
        왼쪽부터 턈색하는데 가장 K떨어진 곳부터 먹는다 . 오른쪽은 가까운 것부터 - 그리디
         */
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            boolean isEat = false;
            if(seq[i] == 'P') {
                for (int j = Math.max(i - K, 0); j < i; j++) {
                    if(seq[j] == 'H') {
                        cnt++;
                        seq[j] = 'X';
                        isEat = true;
                        break;
                    }
                }
                if(isEat) continue;

                for (int j = i+1; j < Math.min(i + K + 1, N); j++) {
                    if(seq[j] == 'H') {
                        cnt++;
                        seq[j] = 'X';
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
