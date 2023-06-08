package solution;

import java.util.Scanner;

public class BOJ11050_이항계수1 {
    static int N,K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        int Ans= 1;
        for (int i = 1, j=N; i <= K; i++,j--) {
            Ans *= j;
            Ans /= i;
        }
        System.out.println(Ans);
    }
}
