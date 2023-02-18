/*
 * SWEA1859_백만장자 - 그리디
 * 막힌 부분 : 최적의 해를 구하는 과정에서 불필요한 반복문 사용으로 시간 초과
 * 막힌 부분2 : 자료형 크기 잘 확인한 후, int를 쓸 수 있는 경우와 없는 경우를 잘 구분짓고 시작하자 . 막히면 끝도 없음. 기본을 충실
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.FileInputStream;

public class SWEA1859_백만장자 {

    static int T, N;
    static int[] price;
    static long Ans = 0L;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            price = new int[N];
            Ans = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            //나보다 큰 값이 있을 때 뺄 값(cost)에 내 값을 더한다
            //뒤에가 항상 제일 크다고 생각 -> 오면서 갱신하자
            long max = Long.MIN_VALUE;
            int n = 0;  //매매 개수
            long cost = 0L;  //초기 구매가(= 나중에 뺄 애들)

            for (int i = price.length - 1; i >= 0; i--) {
                //현재 max값보다 더 큰 수를 발견했을 때
                if (max < price[i]) {
                    //현재까지의 값을 계산하고,
                    Ans += (max * n - cost);
                    //max값 갱신한다
                    max = price[i];
                    //cost, n을 초기화 시켜준다.( 다시 계산해 더할 것이므로)
                    cost = 0;
                    n = 0;

                } else {
                    cost += price[i];
                    n++;
                }
                // 다하고 나오면 계산 마지막 진행한다
            }
            Ans += (max * n - cost);
            sb.append("#").append(tc).append(" ").append(Ans).append("\n");
        }
        System.out.println(sb);
        br.close();

    }

}
