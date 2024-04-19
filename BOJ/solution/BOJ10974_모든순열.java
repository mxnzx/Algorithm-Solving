package solution;

import java.io.*;

public class BOJ10974_모든순열 {

    static int n;
    static StringBuilder ans;

    static void perm(boolean[] visited, int[] pick, int p) {

        if(p == pick.length) {
            for(int n : pick) ans.append(n).append(" ");
            ans.append("\n");
            return;
        }

        for(int i=0; i < n; i++) {
            if(visited[i]) continue;
            pick[p] = i+1;
            visited[i] = true;
            perm(visited, pick, p+1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ans = new StringBuilder();

        perm(new boolean[n], new int[n], 0);

        System.out.println(ans);
    }
}
