

package solution;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ2023_신기한소수 {
    static int N;
    static boolean success=false;
    static ArrayList<Integer> alist = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();
        int start = (int) Math.pow(10,N-1)+1;
        int end = (int) Math.pow(10,N);

        for (int i = start; i < end; i++) {
            success = false;    //성공여부 flag
            checkPrimeNum(i);
            if(success) sb.append(i).append("\n");
        }
        System.out.println(sb);

    }
    private static void checkPrimeNum(int n) {
        //basis part
        if(n == 0) {
            success = true;
            return;
        }
        //지금 소수를 만족하면 다음 자리수로 넘어감
        if(isPrimeNum(n)) {
            checkPrimeNum(n/10);
        } else {
            success = false;
        }
    }

    private static boolean isPrimeNum(int tmp) {
        //소수: 약수가 1과 자신 뿐인 수
        if(tmp == 1) return false;

        for (int i = 2; i < tmp; i++) {
            if(tmp % i == 0) return false;
        }
        return true;
    }
}
