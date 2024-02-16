package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ7568_덩치 {

    static int N;
    static int[][] members;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        members = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            members[i][0] = Integer.parseInt(st.nextToken());
            members[i][1] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int rank = 1;
            for (int j = 0; j < N; j++) {
                    if(i == j) continue;
                    if(members[i][0] < members[j][0]
                            && members[i][1] < members[j][1]) rank++;
            }
            sb.append(rank).append(" ");
        }

        System.out.println(sb);

    }
}
