package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2445_별찍기8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        /*
        1 8 1
        2 6 2
        3 4 3
        4 2 4
        5 0 5
        4 2 4
        ...
         */
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append("*".repeat(i));
            sb.append(" ".repeat(2 * (N-i)));
            sb.append("*".repeat(i));
            sb.append("\n");
        }
        for (int i = N-1; i > 0; i--) {
            sb.append("*".repeat(i));
            sb.append(" ".repeat(2 * (N-i)));
            sb.append("*".repeat(i));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
