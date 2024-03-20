package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9657_돌게임3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //System.out.println(N % 7 == 0 || N % 7 == 2 ? "CY" : "SK");
        boolean[] isWin = new boolean[1001];
        isWin[0] = false;
        isWin[1] = true;
        isWin[2] = false;
        isWin[3] = true;
        isWin[4] = true;
        for (int i = 5; i <= N; i++) {
            // 현재 턴에서 1,3,4 어떤것을 가져가도 그 다음께 true면 현재 턴 플레이어는 false
            if(isWin[i-1] && isWin[i-3] && isWin[i-4]) isWin[i] = false;
            else isWin[i] = true;
        }
        //현재 턴이 상근 먼저니까 이겼니? 그럼 상근이가 이긴거
        System.out.println(isWin[N] ? "SK" : "CY");
    }
}
