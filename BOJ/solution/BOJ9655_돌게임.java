package solution;

import java.util.Scanner;

public class BOJ9655_돌게임 {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        boolean turn = false;    //true: 상근, false: 창영
        backtracking(0,turn);
    }

    private static void backtracking(int num, boolean turn) {
        if(num > N) {
            return;
        }

        if(num == N) {
            if(turn) System.out.println("SK");
            else System.out.println("CY");
            System.exit(0);
        }

        num+=1;
        backtracking(num, !turn);

        num+=3;
        backtracking(num, !turn);
    }
}
