package solution;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> dontKnow = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            dontKnow.add(br.readLine());
        }
        int cnt=0;
        for (int i = 1; i <= M; i++) {
            String noSee = br.readLine();
            dontKnow.add(noSee);
            if((dontKnow.size()) != N+i-cnt) {
                cnt++;
                result.add(noSee);
            }
        }
        sb.append(cnt).append("\n");
        Collections.sort(result);
        for(String s : result) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
