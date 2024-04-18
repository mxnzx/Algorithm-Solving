package solution;

import java.io.*;
import java.util.*;

public class BOJ6198_옥상정원꾸미기 {
    static class Building {
        int idx;
        int height;
        int watchCnt;

        Building(int idx, int height) {
            this.idx= idx;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Building{" +
                    "idx=" + idx +
                    ", height=" + height +
                    ", watchCnt=" + watchCnt +
                    '}';
        }
    }

    static int N;
    static long totalCnt;
    static Building[] buildings;

    static Stack<Building> checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        buildings = new Building[N];
        checked = new Stack<>();
        for (int i = 0; i < N; i++) {
            // i: 인덱스  val:빌딩높이
            buildings[i] = new Building(i, Integer.parseInt(br.readLine()));
        }
        for (int i = N - 1; i >= 0; i--) {
            Building now = buildings[i];
            if (checked.empty()) {
                checked.push(now);
                continue;
            }

            int cnt = 0;
            while (!checked.empty()) {
                // 스택에서 하나 꺼내어 next 라고 둔다.
                Building next = checked.pop();
                // 내 앞이 막혔다면, 일단 다시 그 빌딩을 스택에 넣고 멈춘다.
                if (now.height <= next.height) {
                    checked.push(next);
                    break;
                }
                // 내가 만약 더 크다면, 임시 변수인 cnt에 next가 볼수있는 개수와 next 자신까지 더하고 그 다음껀 되나 안되나 확인하러 반복문을 다시 돌린다.
                if (now.height > next.height) {
                    cnt += next.watchCnt + 1;
                }

            }
            now.watchCnt = cnt;
            checked.push(now);
        }

        for(Building b: buildings) {
            totalCnt += b.watchCnt;
        }
        System.out.println(totalCnt);
    }
}
