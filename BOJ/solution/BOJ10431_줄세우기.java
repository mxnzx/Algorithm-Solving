package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ10431_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int P = Integer.parseInt(br.readLine());
        List<Integer> T;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= P; i++) {
            T = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int tc = Integer.parseInt(st.nextToken());
            sb.append(tc).append(" ");
            long cnt = 0;
            // 실제로 정렬까지 하고 싶은 경우에 이렇게 하지만,
            // 본 문제는 인풋값도 작고, 단순히 cnt만 구하면 되는 문제이므로,
            // 배열 넣고 완탐 돌리는 게 빠르고 메모리도 적게 차지한다.
            for (int j = 0; j < 20; j++) {
                int now = Integer.parseInt(st.nextToken());
                int idx=j;
                for (int k = j-1; k >= 0; k--) {
                    if(T.get(k) < now) {
                        break;
                    } else {
                        cnt++;
                        idx--;
                    }
                }
                T.add(idx, now);
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
