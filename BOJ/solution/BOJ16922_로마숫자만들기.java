/*
 * [BOJ]16922. 로마숫자만들기
 * 중복조합 + 정답 배열
 */

package solution;

import java.util.Scanner;

public class  BOJ16922_로마숫자만들기 {
    static int[] arr = {1,5,10,50};
    static int N,cnt;
    static int[] sel;
    static boolean[] ans = new boolean[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sel = new int[N];

        comb(0,0);
        for(boolean v :ans) {
            if(v) cnt++;
        }
        System.out.println(cnt);


    }
    private static void comb(int idx, int k) {
        if(k == N) {
            int sum=0;
            for(int i : sel) {
                sum+=i;
            }
            ans[sum] = true;
            return;
        }

        for (int i = idx; i < 4; i++) {
            sel[k] = arr[i];
            comb(i,k+1);
        }
    }
}
