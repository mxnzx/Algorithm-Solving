package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1026_보물 {
    static int N;
    static Integer[] arrA, arrB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st,st2;
        N = Integer.parseInt(br.readLine());
        arrA = new Integer[N];
        arrB = new Integer[N];

        st = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());

        for (int j = 0; j < N; j++) {
            arrA[j] = Integer.parseInt(st.nextToken());
            arrB[j] = Integer.parseInt(st2.nextToken());
        }
        //arrA를 내림차순, arrB를 오름차순
        Arrays.sort(arrA, Collections.reverseOrder());
        Arrays.sort(arrB);

        int answer = 0;
        for (int i = 0; i < N; i++) answer += arrA[i] * arrB[i];

        System.out.println(answer);
    }
}
