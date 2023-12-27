package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1931_회의실배정 {
    static class Time {
        int start;
        int end;

        Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
        int getStart() {
            return start;
        }
        int getEnd() {
            return end;
        }

    }
    static int N;
    static Time[] times;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        times = new Time[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        /*
        그리디 알고리즘) 탐욕 선택이 이후의 결과에 영향을 미쳐서는 안됨.
        끝나는 시각을 빠른 순으로 정렬해준다.
        단, 끝나는 시각이 동일할 경우 시작 시각이 빠른 순으로 정렬한다.
        그 후에는 endTime을 정해 시작 시간이 그 이후일 경우를 세어주며 갱신한다.
         */
        Arrays.sort(times, Comparator.comparing(Time::getEnd)
                                     .thenComparing(Time::getStart));

        int endTime = 0, cnt = 0;
        for (int i = 0; i < N; i++) {
            if(endTime <= times[i].start) {
                endTime = times[i].end;
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
