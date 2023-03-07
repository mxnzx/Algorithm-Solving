/*
 * [BOJ]2960. 에라토스테네스의체
 * 재귀
 */

package solution;

import java.util.Scanner;

public class BOJ2960_에라토스테네스의체 {
    static int N, K, cnt, next;
    static boolean[] v;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        v = new boolean[N+1];  //인덱스 2~N까지 사용할것임
        recur(2);
    }
    //p:지우지 않은 수 중 가장 작은 수
    private static void recur(int p) {
        for (int i = 2; i <= N; i++) {
            if(i%p == 0 && !v[i]) { //p의 배수이면서 이전에 지우지 않은 애들을 택한다
                v[i] = true;
                cnt++;  //지울때마다 카운팅
                if(cnt == K) {
                    System.out.println(i);
                    System.exit(0);
                }
            }
        }
        //다 지웠나 확인
        if(!checkV()) recur(next);

    }
    private static boolean checkV() {
        for (int i = 2; i <= N; i++) {
            if(!v[i]) {
                next = i;
                return false;
            }
        }
        return true;
    }

}
