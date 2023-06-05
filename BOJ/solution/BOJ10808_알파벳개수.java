package solution;

import java.util.Scanner;

public class BOJ10808_알파벳개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] S = sc.next().toCharArray();
        int[] alpabet = new int[26];
        //System.out.println((int)S.charAt(0) - 'a');
        for(int n : S) {
            alpabet[(n-'a')]++;
        }
        for(int ans : alpabet) System.out.print(ans + " ");

    }
}
