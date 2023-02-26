/*
 * [BOJ]16922. 로마숫자만들기
 * 중복조합 + set
 * 배열써서 하든 set 써서 하든 시간 똑같음
 */

package solution;
import java.util.HashSet;
import java.util.Scanner;

public class BOJ16922_로마숫자만들기2 {
    static int[] arr = {1,5,10,50};
    static int N;
    static int[] sel;
    static HashSet<Integer> ans = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sel = new int[N];

        comb(0,0);

        //셋은 중복이 안되니 그냥 사이즈 뽑는다
        System.out.println(ans.size());


    }
    private static void comb(int idx, int k) {
        if(k == sel.length) {
            //더해서 정답 셋에 넣어준다
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
