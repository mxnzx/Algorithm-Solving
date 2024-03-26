package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16987_계란으로계란치기 {

    static int N, maxCnt = -1;
    static int[][] eggs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        eggs = new int[N][2];       //0:내구도 1:무게
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            eggs[i][0] = Integer.parseInt(st.nextToken());
            eggs[i][1] = Integer.parseInt(st.nextToken());
        }

        solution(0, 0);
        System.out.println(maxCnt);
    }

    private static void solution(int current, int cnt) {
        maxCnt = Math.max(maxCnt, cnt);
        if(current == N) return;
        // 이미 내가 깨진 경우 오른쪽 계란을 든다
        if(eggs[current][0] <= 0) solution(current+1, cnt);
        else {
            // 여기로 돌아오면서 처음에 못깬 애들을 깬다
            for (int i = 0; i < N; i++) {
                //본인이거나 이미 깨졌으면 패스
                if (current == i || eggs[i][0] <= 0) continue;

                //계란치기 시도
                eggs[i][0] -= eggs[current][1];
                eggs[current][0] -= eggs[i][1];

                //깨진 계란 있으면 카운팅
                if (eggs[i][0] <= 0) cnt++;
                if (eggs[current][0] <= 0) cnt++;
                //오른쪽 계란 들기
                solution(current+1, cnt);
                //복구
                if (eggs[i][0] <= 0) cnt--;
                if (eggs[current][0] <= 0) cnt--;
                eggs[i][0] += eggs[current][1];
                eggs[current][0] += eggs[i][1];
            }
        }
    }
}
