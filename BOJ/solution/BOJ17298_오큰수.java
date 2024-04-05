package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17298_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] seq = new int[N];
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        int[] NGE = solution(N, seq);
        StringBuilder ans = new StringBuilder();
        for(int n : NGE) {
            ans.append(n).append(" ");
        }
        System.out.println(ans);
    }

    private static int[] solution(int n, int[] seq) {
        int[] NGE = new int[n];
        Stack<Integer> large = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int now = seq[i];
            if(large.empty()) {
                NGE[i] = -1;
                large.push(now);
                continue;
            }
            while(!large.empty()) {
                if(now < large.peek()) {
                    NGE[i] = large.peek();
                    large.push(now);
                    break;
                } else {
                    large.pop();
                }
            }
            if(large.empty()) {
                NGE[i] = -1;
                large.push(now);
            }
        }
        return NGE;
    }
}
