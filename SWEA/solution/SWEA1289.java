/*
solution.SWEA1289. 원재의 메모리 복구하기 - 재귀
막힌 부분
1. init[] 초기화는 char형이므로 null임. 0으로 착각함.
2. 재귀함수에서 리턴 전까지는 count맞다가 return count 할때 main에 0을 달고 나옴. 호출했던 곳들의 변수의 값과 독립적이기때문에 당연함. =>static으로 처리해줌.
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA1289 {
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());


        for (int tc = 1; tc <= T; tc++) {
            String str = br.readLine();     //메모리의 원래값
            char[] og = str.toCharArray();

            //초기값 배열
            char[] init = new char[og.length];
            Arrays.fill(init, '0');

            int count = changeBit(og, init, 0,0);

            sb.append("#").append(tc).append(" ").append(count).append("\n");

        }
        System.out.println(sb);
        br.close();
    }
    //idx는 문자열의 인덱스 -> 하나씩 늘린다
    //count 바뀐 횟수
    private static int changeBit(char[] og, char[] init, int idx, int count) {
        //========== basis part =========

        if (Arrays.toString(og).equals(Arrays.toString(init))) {
            ans = count;
            return ans;
            //return count;   //여기서 리턴하면 0으로 나감. 왜? -> 호출했던곳들로 가다보면 거기 ans 0임. -> static으로 선언해주자
        }
        //========== inductive part =========

        //둘이 다르면 temp 바꾼다
        if (og[idx] != init[idx]) {
            char c = og[idx];
            for (int i = idx; i < init.length; i++) {
                init[i] = c;
            }
            changeBit(og, init, idx + 1, count + 1);
        } else {
            //아니면 idx만 올려
            changeBit(og, init, idx + 1, count);
        }
        return ans;

    }
}
