package solution;

import java.util.*;
import java.io.*;

public class BOJ17219_비밀번호찾기 {

    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map<String, String> pwFinder = new HashMap<>();
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            pwFinder.put(st.nextToken(), st.nextToken());
        }

        StringBuilder ans = new StringBuilder();
        while(M-- > 0) {
            String siteDomain = br.readLine();
            ans.append(pwFinder.get(siteDomain)).append("\n");
        }
        System.out.println(ans);
    }
}
