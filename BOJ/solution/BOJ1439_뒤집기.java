package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1439_뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st1 = new StringTokenizer(input,"0");
        StringTokenizer st0 = new StringTokenizer(input, "1");
        System.out.println(Math.min(st1.countTokens(), st0.countTokens()));
    }
}
