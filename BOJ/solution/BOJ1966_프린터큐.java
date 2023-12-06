package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1966_프린터큐 {
    static int T, N, M;

    static class Num {
        int order;
        int value;

        public Num(int order, int value) {
            this.order = order;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());   // 총 개수
            M = Integer.parseInt(st.nextToken());   // 내가 알고싶은 인덱스 번호
            Queue<Num> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int max = -1;
            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                max = Math.max(max, input);
                q.offer(new Num(j,input));
            }
            int cnt = 1;
            while(!q.isEmpty()) {
                Num current = q.peek();
                if (max != current.value) {
                    Num tmp = q.poll();
                    q.offer(tmp);
                } else {
                    q.poll();
                    max = -1;
                    for(Num n : q) {
                        max = Math.max(max, n.value);
                    }
                    if(M == current.order) break;
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
