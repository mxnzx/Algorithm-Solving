package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2531_회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //접시 수
        int d = Integer.parseInt(st.nextToken());   //초밥 가짓수
        int k = Integer.parseInt(st.nextToken());   //연속으로 먹는 접시 수
        int c = Integer.parseInt(st.nextToken());   //쿠폰번호
        int[] menu = new int[N];
        for (int i = 0; i < N; i++) {
            menu[i] = Integer.parseInt(br.readLine());
        }
        solution(N, d, k, c, menu);
    }

    private static void solution(int n, int d, int k, int c, int[] menu) {
        int[] sushi = new int[d+1];
        sushi[c]++;
        int cnt = 1;
        //현재 먹을 수 있는 메뉴를 sushi에 표시한다
        for (int i = 0; i < k; i++) {
            if(sushi[menu[i]] == 0) cnt++;
            sushi[menu[i]]++;
        }
        int answer = cnt;
        for (int i = k; i < n+k; i++) {
            // 맨 처음 먹은 거 뺀다
            sushi[menu[(i-k)%n]]--;
            if(sushi[menu[(i-k)%n]] == 0) cnt--;
            // 가장 최근 먹은 거 더한다
            if(sushi[menu[i%n]] == 0) cnt++;
            sushi[menu[i%n]]++;
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }
}
