package solution;

import java.io.*;
import java.util.*;
public class BOJ15829_해싱 {

    static final int R = 31, M = 1234567891;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        long hashValue = 0;
        for(int i = 0; i < n; i++) {
            long val = (input[i] - 'a' + 1);
            for(int j = 0; j < i; j++) {
                val *= R;
                val %= M;
            }
            hashValue += val;
        }
        System.out.println(hashValue % M);
    }
}
