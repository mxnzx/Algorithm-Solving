package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1715_카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> cards = new PriorityQueue<>(Integer::compareTo);
        for (int i = 0; i < N; i++) {
            cards.add(Integer.parseInt(br.readLine()));
        }
        /*
        작은 숫자 두개를 더해,
        그 다음 작은 수와 계속 더하게 하는 것이 가장 작은 수를 나오게 하는 방법이다.
        작은 두 수를 꺼내 더한 다음 다시 큐에 넣는다. 이때 큐는 우선순위큐.
         */
        if(N == 1) {
            System.out.println(0);
            return;
        }
        int ans = 0;
        while(cards.size() > 1) {
            int a = cards.poll();
            int b = cards.poll();
            ans += a+b;
            cards.add(a+b);
        }
        System.out.println(ans);
    }
}
