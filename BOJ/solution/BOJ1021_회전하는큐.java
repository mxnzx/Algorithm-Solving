package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ1021_회전하는큐 {
    static int N, M, cnt;
    static Deque<Integer> dq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dq = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            dq.addLast(i);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());
            func(n);
        }
        System.out.println(cnt);
    }

    public static void func(int n) {

        if(compare(n)) {
            while (true) {
                int now = dq.poll();
                if (n == now) {
                    break;
                }
                dq.addLast(now);
                cnt++;
            }
        } else {
            while(true) {
                int now = dq.pollLast();
                cnt++;
                if(n == now) {
                    break;
                }
                dq.addFirst(now);
            }
        }
    }

    // 2,3 번 중에 뭐가 더 효율적인지 비교하는 메서드
    public static boolean compare(int n) {
        int leftCnt = 0;
        int size = dq.size();
        Stack<Integer> tmpStack = new Stack<>();

        while (true) {
            int now = dq.poll();
            tmpStack.push(now);
            if (n == now) {
                break;
            }
            leftCnt++;
        }
        while(!tmpStack.isEmpty()) {
            dq.addFirst(tmpStack.pop());
        }
        int rightCnt = size - leftCnt;

        return leftCnt <= rightCnt;

    }
}
