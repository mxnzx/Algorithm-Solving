package solution;

import java.io.*;
import java.util.*;

public class BOJ1541_잃어버린괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        int ans = 0;
        boolean isFirst = true;
        while(st.hasMoreTokens()) {
            String token = st.nextToken();
            StringTokenizer st2 = new StringTokenizer(token, "+");
            int tmp = 0;
            while(st2.hasMoreTokens()) {
                tmp += Integer.parseInt(st2.nextToken());
            }
            ans = isFirst ? ans+tmp : ans-tmp;
            isFirst = false;
        }
        System.out.println(ans);
    }
}
