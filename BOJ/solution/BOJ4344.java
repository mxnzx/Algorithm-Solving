package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            int studentNum = Integer.parseInt(st.nextToken());
            int[] scores = new int[studentNum];
            int sum=0;

            for (int i = 0; i < studentNum; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
                sum += scores[i];
            }
            float avg = (float) sum / studentNum;
            int passStudent = 0;
            //평균 넘는 학생들 구하기
            for ( float s : scores) {
                if(s > avg) { passStudent++; }
            }
            String ans = String.format("%.3f", (float) passStudent / studentNum * 100) ;
            sb.append(ans).append("%\n");

        }
        System.out.println(sb);
        br.close();
    }
}
