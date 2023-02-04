//블로그 - 누적 합

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   //n일
        int x = Integer.parseInt(st.nextToken());   //x일동안 방문자 수

        int[] days = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            days[i] = Integer.parseInt(st.nextToken());
        }

        //최대 방문자 수 출력 - 누적합
        int sum = 0;
        //초기값 sum
        for (int i = 0; i < x; i++) {
            sum += days[i];
        }
        //초기 최댓값 설정
        int max = sum;
        //초기 최댓값 빈도수 설정
        int maxDayCnt= 1;
        //맨 왼쪽 제거, 오른쪽 다음 추가해서 합 갱신
        for (int i = 0; i < n-x; i++) {
            sum = sum + (days[i + x] - days[i]);
            if(sum >= max ) {
                //max값과 같다면 maxDayCnt++해준다
                if( sum == max ) {
                    maxDayCnt++;
                } else {        //max값이 갱신됐는데 더 크다면, maxDayCnt를 다시 1로 바꿔줌 ***
                    max = sum;
                    maxDayCnt=1;
                }
            }
        }
        //출력
        if(max == 0) {
            sb.append("SAD");
        } else{
            sb.append(max).append("\n").append(maxDayCnt);
        }

        System.out.println(sb);
        br.close();

    }
}

