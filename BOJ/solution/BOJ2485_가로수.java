package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ2485_가로수 {
    public static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }
        int gcd = 0;
        for (int i = 0; i < N-1; i++) {
            int gap = trees[i+1] - trees[i];
            gcd = gcd(gap, gcd);
        }
        int cnt = (trees[N-1]-trees[0]) / gcd + 1 - trees.length;
        System.out.println(cnt);
    }
}
