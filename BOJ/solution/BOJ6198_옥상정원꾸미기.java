package solution;

import java.io.*;
import java.util.*;

public class BOJ6198_옥상정원꾸미기 {
    static class Building {
        int idx;
        int height;

        Building(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Building> buildings = new Stack<>();
        Stack<Building> stack = new Stack<>();
        long[] cnt = new long[N+1];
        for (int i = 0; i < N; i++) {
            buildings.add(new Building(i + 1, Integer.parseInt(br.readLine())));
        }

        while(!buildings.isEmpty()) {
            Building now = buildings.pop();
            long tmpCnt = 0;

            while(!stack.empty()) {
                Building other = stack.peek();
                // 현재 높이가 더 크면 기존꺼 스택에서 빼고, 현재 볼수 있는 건물 카운팅 갱신
                if(now.height > other.height) {
                    // 기존 other가 볼 수 있었던 cnt수에 본인(+1)까지 카운팅한다.
                    tmpCnt += cnt[other.idx] + 1;
                    stack.pop();
                } else {
                    // 현재 높이가 작거나 같으면 벗어난다.
                    break;
                }
            }
            stack.push(now);
            cnt[now.idx] = tmpCnt;
        }

        long ans = 0;
        for(long n : cnt) {
            ans += n;
        }

        System.out.println(ans);
    }
}
