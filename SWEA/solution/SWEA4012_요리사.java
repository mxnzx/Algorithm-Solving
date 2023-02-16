
/*
 * N개 중에 N/2개를 골라 각각 값을 계산 -> 조합에 다음순열을 사용해서 두 그룹으로 나누자
 * 하고 둘 중 작은 차 정답
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA4012_요리사 {

    static int T, N, Ans;
    static int[][] map;
    static int[] s;
    static int[] check;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());
            map = new int[N + 1][N + 1];
            check = new int[ ? ]; //Nx
            s = new int[N]; // 내가 고른 식재료 배열
            Ans = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            sb.append("#" + tc + " " + Ans + "\n");
        }
        System.out.println(sb);
        br.close();

    }

    private static void comb(int[] sel, int idx, int k) {

        if (k == sel.length) {
            // 각각 뽑은 수로 시너지의 합을 구한다. e.g. [1,2,3] -> map[1][2] + map[2][1] + map[1][3] +
            // map[3][1] + map[2][3] + map[3][2]
            // 여기서 뽑은 수로 순열 ?


            return;
        }
        for (int i = idx; i < s.length; i++) {
            sel[k] = s[i];
            comb(sel, i + 1, k + 1);
        }

    }
    //다음 순열을 가져오는 메소드
    private static boolean np(int[] input) {

        int n = input.length;

        //1. 뒤쪽부터 꼭대기를 찾는다.
        int i = n - 1;
        while(i>0 && input[i] <= input[i-1]) i--;
        if(i == 0) return false;

        //2. 꼭대기 바로 앞자리와 그 자리값보다 한단계 큰 자리를 수를 뒤부터 찾는다
        int j = n - 1;
        while(input[i-1] >= input[j]) j--;

        //3. 꼭대기 바로 앞자리와 그 자리값보다 한단계 큰 자리를 수와 교환한다.
        swap(input, i-1, j);

        //4. 꼭대기부터 맨 뒤까지 오름차순으로 정렬한다
        int k = n - 1;
        while(i<k)
            swap(input, i++, k--);

        return true;
    }

    private static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }


}
