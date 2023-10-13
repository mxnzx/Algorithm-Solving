package solution;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1946_신입사원 {
    static int T, N, ans;
    static int[] scores;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            scores = new int[100001];   //인덱스 1부터 서류 등수 오름차순으로 들어간다
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                scores[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            ans = 1;  //1번은 무조건 패스
            int min = scores[1];
            for (int j = 2; j <= N; j++) {
                if(min > scores[j]) {
                    min = scores[j];
                    ans++;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
