/*
 * [BOJ]1914. 하노이탑
 * 재귀, BigInteger 사용 -> 기본 사칙연산은 타입 맞춰야하지만, pow메서드 쓸때 지수는 int로 받는다.
 */

package solution;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ1914_하노이탑 {
    static int N,K=0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = new BigInteger("2");
        N = sc.nextInt();

        if(N<=20) {
            hanoi(N,1,2,3);
            sb.insert(0,K + "\n");
        } else {
            n=n.pow(N);
            n = n.subtract(new BigInteger("1"));
            sb.append(n);
        }
        System.out.println(sb);
    }
    private static void hanoi(int num, int from, int mid, int to) {

        K++;

        //basis part
        if(num == 1) {
            sb.append(from + " "+to+"\n");
            return;
        }
        //inductive part

        //n-1개를 A에서 B로 이동
        hanoi(num-1,from,to,mid);
        //1개를 A에서 C로 이동
        sb.append(from + " " + to + "\n");
        //N-1개를 B에서 C로 이동
        hanoi(num-1,mid,from,to);


    }
}
