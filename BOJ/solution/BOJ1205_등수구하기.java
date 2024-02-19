package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1205_등수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());       //랭킹 리스트에 올라갈 수 있는 점수의 개수
        int[] scores = new int[N];    //비오름차순 > 내림차순인데 같은 수가 인접할 수 있다
        /*
        제일 높은게 1
        같은 점수 > 점수 등수 중에 가장 작은 등수.
        만약 정렬을 완료했는데 P보다 작거나 같으면 출력, 아니면 -1
         */
        if(N <= 0) {
            System.out.println(1);
            return;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        if(N == P && newScore <= scores[N-1]) {
            System.out.println(-1);
            return;
        }
        int rank = 1;
        for (int i = 0; i < N; i++) {
            if(newScore >= scores[i]) {
                rank = i + 1;
                break;
            } else {
                rank++;
            }
        }

        if(rank <= P) {
            System.out.println(rank);
        } else {
            System.out.println(-1);
        }

    }
}
