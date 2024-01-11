package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110_공유기설치 {
    static int N, C;
    static int[] loc;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        loc = new int[N];
        for (int i = 0; i < N; i++) {
            loc[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(loc);
        // Upper Bound
        int start = 1, end = loc[N-1] - loc[0] + 1;
        while(start < end) {

            int mid = (start + end) / 2;

            // mid 거리에 대해 설치 가능한 공유기 개수가 C보다 적으면 거리를 좁힌다.
            if(countEnjoyWifi(mid) < C) end = mid;
            // 설치 가능한 공유기 개수가 C보다 크거나 같을 경우, 거리를 벌려 최소거리의 최댓값을 찾는다.
            else start = mid + 1;
        }
        System.out.println(start - 1);
    }

    private static int countEnjoyWifi(int minDist) {
        /*
        여기서 내가 어느 집에 공유기를 설치할 지 어떻게 알지?
        -> 첫번째집은 무조건 설치한다고 가정한다.
        -> 최소 거리가 최대가 되기 위해서는 첫번째 집은 설치가 되어있어야 한다.
         */
        int cnt = 1;
        int lastLoc = loc[0];

        for (int i = 1; i < loc.length; i++) {
            int locate = loc[i];
            /*
            현재 탐색하는 집의 위치(locate)와 직전에 설치했던 집의 위치(lastLoc) 사이 거리가
            최소 거리(minDist)보다 크거나 같으면 공유기 설치 개수를 늘리고,
            마지막 설치 위치를 갱신한다.
             */
            if(locate - lastLoc >= minDist) {
                cnt++;
                lastLoc = locate;
            }
        }
        return cnt;
    }
}
