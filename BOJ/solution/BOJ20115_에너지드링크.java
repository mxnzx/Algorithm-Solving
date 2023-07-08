package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ20115_에너지드링크 {
    static int N;
    static double[] drink;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        drink = new double[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            drink[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(drink);
        for (int i = 0; i < N-1; i++) {
            drink[N-1] += drink[i]/2;
        }
        System.out.println(drink[N-1]);
    }
}
