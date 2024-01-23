package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ9017_크로스컨트리 {


    static int T, N;
    static int[][] players;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        /*
        저장해야하는 정보: 소속 팀(리스트의 인덱스), 들어온 순서에 따른 점수, 각 팀별 들어온 선수의 명 수와 등수
        몇 팀이 참가하는 지 모름 -> 배열 어려움.
        팀 리스트 - 인덱스로
         */
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            players = new int[201][6];    // 소속 팀, 각 팀의 선수 = 받은 점수 기입
            // 바로 점수를 넣을 수 있는 구조가 안됨 -> 한번 입력 받고, 그 뒤에 다시 점수 넣어야 함
            // 필요한 건 소속 팀과 6명 들어왔는지 >> 소속팀넘버, 내가 들어온순서
            Map<Integer, Integer> team = new HashMap<>();
            String initInput = br.readLine();
            st = new StringTokenizer(initInput); //1 2 3 3 1 3 2 4 ,,
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(st.nextToken());
                if(team.containsKey(n)) {
                    int val = team.get(n);
                    team.put(n, val+1);
                } else {
                    team.put(n,1);
                }
            }
            st = new StringTokenizer(initInput);
            int[] newInput = new int[N+1];
            int idx = 1;
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(st.nextToken());
                if(team.get(n) == 6) newInput[idx++] = n;
            }
            System.out.println(Arrays.toString(newInput));

            // 6명 안 들어온 팀 제거했고, 이제 점수 매겨서 player배열에 기입한다
            for (int i = 1; i <= N ; i++) {
                if(newInput[i] == 0) break;
                for (int j = 0; j < 6; j++) {
                    if(players[newInput[i]][j] == 0) {
                        players[newInput[i]][j] = i;
                        break;
                    }
                }
            }
//            for (int i = 1; i <= 200; i++) {
//                System.out.println(Arrays.toString(players[i]));
//            }
            // min 값 구한다.
            int minTeam = 0;
            int minScore = Integer.MAX_VALUE;
            for (int i = 1; i <= 200; i++) {
                if(players[i][0] == 0) continue;
                int score = 0;
                for (int j = 0; j < 4; j++) {
                    score += players[i][j];
                }
                if(minScore > score) {
                    minScore = score;
                    minTeam = i;
                } else if (minScore == score) {
                    minTeam = (players[minTeam][4] < players[i][4]) ? minTeam : i;
                }
            }
            sb.append(minTeam).append("\n");
        }
        System.out.println(sb);
    }
}
