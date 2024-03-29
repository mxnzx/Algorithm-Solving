package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ20055_컨베이어벨트위의로봇 {

    static int N, K;
    static int[] belt;
    static boolean[] robots;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new int[2*N];
        robots = new boolean[N]; //인덱스로 관리. 값이 true면 해당 인덱스의 belt에 로봇있음
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2*N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }

    private static void solution() {
        int stage = 0;
        while (true) {
            stage++;
            // 로봇과 함께 회전: 맨 뒤를 제거하고 앞에 붙인다
            int tmp = belt[belt.length - 1];
            for (int i = belt.length - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
            }
            belt[0] = tmp;

            //로봇 회전: 로봇배열 한칸씩 이동
            for (int i = N -1; i > 0; i--) {
                robots[i] = robots[i-1];
            }
            robots[0] = false;

            //로봇이 이동할 수 있다면 이동
            moveRobot();
            //올리는 위치에 로봇 올릴 수 있다면 올림
            if(belt[0] > 0) {
                robots[0] = true;
                belt[0]--;
            }
            //0칸 세고 판단
            if(checkZero(0)) break;
        }
        System.out.println(stage);
    }

    private static void moveRobot() {
        robots[N-1] = false;    //N-1 = 내린다
        for (int i = N-1; i > 0; i--) {
            if(robots[i-1] && belt[i] > 0 && !robots[i]) {
                robots[i] = true;
                robots[i-1] = false;
                belt[i]--;
            }
        }
    }

    private static boolean checkZero(int cnt) {
        for (int n : belt) {
            if (n == 0) cnt++;
            if (cnt == K) return true;
        }
        return false;
    }
}
