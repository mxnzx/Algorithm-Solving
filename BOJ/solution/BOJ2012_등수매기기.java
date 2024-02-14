package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2012_등수매기기 {
    static int N;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rank = new int[N];
        for (int i = 0; i < N; i++) {
            rank[i] = Integer.parseInt(br.readLine());
        }
        /*
        그리디..? 같은디..
        그럼 일단 정렬한다
        2 2 2 4 5
        1 2 3 4 5 << 불만도 1+1+1 = 3

        어차피 N명중이므로 모든 애들은 1~N 사이의 등수를 써서 냈을 것이고,
        그렇다면 정렬해서 차이를 구하는게 최소일것이라고 판단.
         */
        Arrays.sort(rank);
        long unhappy = 0;
        int realRank = 1;
        for(int n : rank) {
            unhappy += Math.abs(realRank - n);
            realRank++;
        }
        System.out.println(unhappy);
    }
}
