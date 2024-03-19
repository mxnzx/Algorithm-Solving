package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ14891_톱니바퀴 {

    static int K;
    static List<Integer>[] gears;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 4개의 톱니바퀴를 어디에 저장할까
        // 1. 덱 - 인덱스 비교에 빡셈
        // 2. 연결리스트 - 괜찮은듯!
        gears = new ArrayList[4];
        for (int i = 0; i < 4; i++) {
            String input = br.readLine();
            gears[i] = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                gears[i].add(input.charAt(j) - '0');
            }
        }
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());    //1: 시계 -1: 반시계
            rotationGear(num-1, dir);
        }
        // 점수 출력
        int answer = 0;
        int score = 1;
        for (int i = 0; i < 4; i++) {
            answer += gears[i].get(0) == 1 ? score : 0;
            score *= 2;
        }
        System.out.println(answer);

    }

    private static void rotationGear(int num, int dir) {

        Boolean[] isRightTurn = new Boolean[4];
        isRightTurn[num] = dir == 1;

        for (int i = num - 1; i >= 0; i--) {
            // 현재의 2번과 오른쪽의 6번 비교
            if(gears[i].get(2).equals(gears[i+1].get(6))) break;
            isRightTurn[i] = !isRightTurn[i+1];
        }
        for (int i = num+1; i < 4; i++) {
            // 현재의 6번과 이전의 2번 비교
            if(gears[i].get(6).equals(gears[i-1].get(2))) break;
            isRightTurn[i] = !isRightTurn[i-1];
        }

        for (int i = 0; i < 4; i++) {
            if(isRightTurn[i] != null) {
                rotateByOne(isRightTurn[i], i);
            }
        }
    }
    private static void rotateByOne(boolean isRightTurn, int i) {
        if(isRightTurn) {
            int end = gears[i].get(7);
            gears[i].remove(7);
            gears[i].add(0, end);
        } else {
            int start = gears[i].get(0);
            gears[i].remove(0);
            gears[i].add(start);
        }
    }
}
