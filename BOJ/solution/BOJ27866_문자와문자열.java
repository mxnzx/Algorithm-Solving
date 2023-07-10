package solution;

import java.util.Scanner;

public class BOJ27866_문자와문자열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        System.out.println(str.charAt(n-1));
    }
}
