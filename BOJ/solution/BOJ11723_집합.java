package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ11723_집합 {
    static int M;
    static Set<Integer> S;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 그룹 내 중복 안되고, 값 찾아야 함 >> set 사용
        S = new HashSet<>();
        M = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if(op.equals("all") || op.equals("empty")) {
                check(op,-1);
            } else {
                int x = Integer.parseInt(st.nextToken());
                check(op, x);
            }
        }
        System.out.println(sb);
    }

    private static void check(String op, int x) {
        switch (op) {
            case "add":
                S.add(x);
                break;
            case "remove":
                S.remove(x);
                break;
            case "check":
                if (S.contains(x)) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append("\n");
                break;
            case "toggle":
                if (S.contains(x)) {
                    S.remove(x);
                } else {
                    S.add(x);
                }
                break;
            case "all":
                S.clear();
                for (int i = 1; i <= 20; i++) {
                    S.add(i);
                }
                break;
            default:
                S.clear();
                break;
        }
    }
}
