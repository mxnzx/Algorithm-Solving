package solution;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ6996_애너그램 {

    private static boolean solveAnagrams(String first, String second ) {
        char[] A = first.toCharArray();
        char[] B = second.toCharArray();
        if(A.length != B.length) return false;

        Arrays.sort(A);
        Arrays.sort(B);

        return Arrays.equals(A,B);

        /* -------------------- END OF INSERTION --------------------*/
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();

        for (int i = 0; i < numTests; i++) {
            String first = sc.next().toLowerCase();
            String second = sc.next().toLowerCase();

            System.out.println(first + " & " + second + " are " + (solveAnagrams(first, second) ? "anagrams." : "NOT anagrams."));
        }
    }
}