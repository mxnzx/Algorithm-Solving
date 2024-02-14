package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2442_별찍기5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        /*
        4 1
        3 3
        2 5
        1 7
        0 9
         */
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(" ".repeat(N - i));
            sb.append("*".repeat(Math.max(0, 2 * i - 1)));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
