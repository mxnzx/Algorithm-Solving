package solution;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1946_신입사원 {
    static int T, N, ans;
    static class Score {
        int first;
        int second;
        public Score(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        @Override
        public String toString() {
            return "Score{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            Score[] scores = new Score[N];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                scores[j] = new Score(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            Arrays.sort(scores, Comparator.comparing(Score::getFirst));
            //System.out.println(Arrays.toString(scores));

            ans = 1;  //1번은 무조건 패스
            boolean pass = true;
            for (int j = 1; j < N; j++) {
                if(pass && scores[j].second > scores[j-1].second)
//                for (int k = 0; k < j; k++) {
//                    // 현재 확인하고 있는 타겟의 면접 등수가 앞(k) 보다 크면 등수가 밀리는 것이므로 플래그를 false 주고 나온다.
//                    if(scores[j].second > scores[k].second) {
//                        pass = false;
//                        break;
//                    }
//                    //System.out.println(k);
//                }
//                if(pass) {
//                    //System.out.println("j: " + j);
//                    ans++;
//                }
            }

            sb.append(ans).append("\n");
            /*
            - 일단 서류로 정렬을 시행한다. 내 앞과 비교한다. O(n^2)
            - 내 앞이랑만 비교. 걔가 패스를 했는데 내가 앞보다 커. 그러면 통과.
                             만약 앞보다 작아. 그러면 실패
                             앞이 이미 실패야. 나는 얘보다 커. 그럼 실패
                             앞이 이미 실팬데 나는 얘보다 작아. 그럼 그 이전과 비교해야돼?
            1 4 - 패스
            2 3 - 패스
            3 2 - 패스
            4 1 - 패스
            5 5 - 실패

            1 4 - 패스
            2 5 - 실패
            3 6 - 실패
            4 2 - 패스
            5 7 - 실패
            6 1 - 패스
            7 3 - 실패
             */

        }
        System.out.println(sb);

    }
}
