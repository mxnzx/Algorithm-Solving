package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16953_AB {
    static int A,B,min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int answer = calc(A,0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer+1);
    }
    private static int calc(double num, int cnt) {
        System.out.println(num + " " + cnt);
        if(num > B) return 0;
        if (num == B) min = Math.min(min,cnt);

        calc(num * 2, cnt + 1);
        calc(num * 10 + 1, cnt + 1);

        return min;
    }
}
