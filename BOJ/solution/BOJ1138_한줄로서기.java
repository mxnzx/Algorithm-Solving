package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1138_한줄로서기 {
    static int N;
    static int[] people;
    static List<Integer> order;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        people = new int[N+1];
        order = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        // 키가 큰 애들부터 본인의 순서에 맞게 서게 하면 해당자리에 있던 애는 자연스레 뒤로 밀림..
        for (int i = N; i > 0; i--) {
            order.add(people[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(order.get(i)).append(" ");
        }
        System.out.println(sb);

    }
}
