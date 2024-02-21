package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ3758_KCPC {

    static class Team {
        int id;
        int submitCnt;
        int submitOrder;
        int totalScore;
        int[] scores;
        int rank;

        public Team(int id) {
            this.id = id;
        }
    }

    static int n, k, myTeam, m;
    static Team[] teams;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            myTeam = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            teams = new Team[n];

            /*
            점수와 관련된 데이터: 점수, 제출 횟수 갱신, 제출 시간 계속 갱신
            점수는 동일한 문제에 다회 들어올 경우, 최고 점수 저장. 없다면 0
            동일 순위 미존재. 제출시간이 전부 다르기 때문
             */
            for (int i = 0; i < n; i++) {
                teams[i] = new Team(i+1);
                teams[i].scores = new int[k + 1];
            }
            for (int i = 1; i <= m; i++) {
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken());
                int qNum = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                teams[teamId-1].scores[qNum] = Math.max(s, teams[teamId-1].scores[qNum]);
                teams[teamId-1].submitCnt++;
                teams[teamId-1].submitOrder = i;
            }

            sumScoreByTeam();
            sb.append(ranking()).append("\n");
        }
        System.out.println(sb);

    }

    private static int ranking() {

        Arrays.sort(teams, new Comparator<Team>() {
            @Override
            public int compare(Team o1, Team o2) {
                if (o1.totalScore == o2.totalScore) {
                    if(o1.submitCnt == o2.submitCnt) {
                        return o1.submitOrder - o2.submitOrder;
                    }
                    return o1.submitCnt - o2.submitCnt;
                }
                return o2.totalScore - o1.totalScore;
            }
        });

        //내 팀의 랭킹 출력
        for(int i=0; i<n;i++) {
            if(teams[i].id == myTeam) {
                return i+1;
            }
        }
        return -1;

    }

    private static void sumScoreByTeam() {
        for (int i = 0; i < n; i++) {

            for (int s : teams[i].scores) {
                teams[i].totalScore += s;
            }
        }
    }
}
