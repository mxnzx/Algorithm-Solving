package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA2112_보호필름 {
    static StringBuilder sb = new StringBuilder();
    static int T, D, W, K, ans;
    static int[][] film;
    static int[] pass;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken()); // 연속해야하는 막의 개수
            ans = 0;
            film = new int[D][W];
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                } // 0: A, 1:B
            }
            // 일단 검사
            if (!checkCell()) changeCell();
            sb.append("#").append(tc).append(" ").append(ans).append("\n");

        }
        System.out.println(sb);
    }

    //하나씩 바꿔보고 안되면 두개,,, 안되면 세개,,?
    private static void changeCell() {

        //nC1부터 시작
        for (int i = 1; i <= D; i++) {
            //뽑아온 애들을 A로 바꾸는 경우와 B로 바꾸는 경우의 수가 있다 -> 복사해서 쓴다
            comb(0, 0, new int[i]);
        }


    }

    //idx: 뽑으려는 인덱스, k:뽑은 개수
    private static int[] comb(int idx, int k, int[] sel) {

        if (k == sel.length) {
            //A로 바꿀지 B로 바꿀지 다해본다
            choiceAB(sel);
            return sel;
        }

        for (int i = idx; i < D; i++) {
            sel[k] = i;
            comb(i + 1, k + 1, sel);
        }
        return sel;

    }

    private static void choiceAB(int[] sel) {
        int n = sel.length();



    }


    private static boolean checkCell() {
        pass = new int[W];
        for (int i = 0; i < D - 1; i++) {
            for (int j = 0; j < W; j++) {
                // 이전의 것과 다르다면 값을 0으로 초기화 / 같다면 cnt++
                if (film[i][j] == film[i + 1][j]) pass[j]++;
                else pass[j] = 0;
            }
        }
        for (int cnt : pass) {
            if (cnt < K) return false;
        }
        return true;
    }
}
