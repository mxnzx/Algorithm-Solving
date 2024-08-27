package solution;

import java.util.*;
import java.io.*;

public class BOJ19583_싸이버개강총회 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 00:00을 0으로 놓고 분 단위로 변환한다.
        st = new StringTokenizer(br.readLine());
        int startTime = changeTime(st.nextToken());
        int endTime = changeTime(st.nextToken());
        int endStreamingTime = changeTime(st.nextToken());
        Set<String> attendCnt = new HashSet<>();
        Set<String> outCnt = new HashSet<>();

        String input;
        while((input = br.readLine()) != null) {

            st = new StringTokenizer(input);
            if(input.equals("")) break;
            int chattedTime = changeTime(st.nextToken());
            String nickname = st.nextToken();

            if(chattedTime <= startTime) attendCnt.add(nickname);
            // 퇴장 체크
            if(chattedTime >= endTime && chattedTime <= endStreamingTime) {
                outCnt.add(nickname);
                continue;
            }
            if(chattedTime > endStreamingTime) break;
        }

        int ans = 0;
        for(String name : outCnt) {
            if(attendCnt.contains(name)) ans++;
        }
        System.out.println(ans);
    }

    private static int changeTime(String time) {
        int hour = Integer.parseInt(time.substring(0,2));
        int minute = Integer.parseInt(time.substring(3));

        return hour * 60 + minute;
    }
}
