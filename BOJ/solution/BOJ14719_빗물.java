package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ14719_빗물 {
    static int H, W;
    static int[] blocks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        blocks = new int[W];
        st = new StringTokenizer(br.readLine());
        int startIdx = 0;
        boolean flag = false;
        // 1. 0보다 큰 수를 찾는다
        for (int i = 0; i < W; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
            if (!flag && blocks[i] > 0) {
                startIdx = i;
                flag = true;
            }
        }
        //2. startIdx 부터 작으면 넘어가고, 크거나 같으면 저장하고  startIdx갱신
        int ans = 0;
        int[] water = new int[W];

        for (int i = startIdx + 1; i < W; i++) {
            if (blocks[startIdx] <= blocks[i]) {
                startIdx = i;
            } else {
                water[i] = blocks[startIdx] - blocks[i];
            }
        }
        //3. 갱신이 안된 구간부터 끝까지 받아논 물 처리하기
        if (startIdx != W - 1) {
            Stack<Integer> large = new Stack<>();
            for (int i = W-1; i > startIdx; i--) {
                // 내가 내 오른쪽의 가장 큰 값을 찾아 water 에 넣으면 됨
                while(!large.empty()) {
                    if(large.peek() > blocks[i]) {
                        water[i] = large.peek() - blocks[i];
                        break;
                    } else {
                        large.pop();
                    }
                }
                if(large.empty()) {
                    water[i] = 0;
                    large.push(blocks[i]);
                }
            }
        }
        for(int n : water) {
            ans += n;
        }
        System.out.println(ans);
    }
}
