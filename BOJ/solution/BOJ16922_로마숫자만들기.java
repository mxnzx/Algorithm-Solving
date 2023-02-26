/*
 * [BOJ]16922. 로마숫자만들기
 * 중복조합
 */

package solution;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class  BOJ16922_로마숫자만들기 {
    static int[] arr = {1,5,10,50};
    static int N,cnt;
    static int[] sel;
    static HashSet<Integer> ans = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sel = new int[N];

        comb(0,0);
        System.out.println(ans.size());


    }
    private static void comb(int idx, int k) {
        if(k == sel.length) {
            int sum=0;
            for(int i : sel) {
                sum+=i;
            }
            ans.add(sum);
            return;
        }

        for (int i = idx; i < 4; i++) {
            sel[k] = arr[i];
            comb(i,k+1);
        }
    }
}
