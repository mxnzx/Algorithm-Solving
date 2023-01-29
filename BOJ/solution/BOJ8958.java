package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            String quizResult = br.readLine();
            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < quizResult.length(); i++) {
                char c = quizResult.charAt(i);
                //c가 O이면 ++cnt X일때 cnt=0 => sum+=cnt;
                cnt = ( c == 'O') ? ++cnt : 0;  //이 라인에서 cnt를 올려야하기 때문에 ++cnt로 써주어야 함
                sum += cnt;
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}

