package solution;

import java.io.*;

public class BOJ5525_IOIOI {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());    //str의 길이
        String str = br.readLine();
        int ans = 0;
        int cnt = 0;
        for(int idx = 1; idx < m - 1;) {
            if(str.charAt(idx) == 'O' && str.charAt(idx+1) == 'I') {
                cnt++;
                if(cnt == n) {
                    if (str.charAt(idx - (cnt * 2 - 1)) == 'I') ans++;
                    cnt--;
                }
                idx += 2;
            } else {
                cnt = 0;
                idx++;
            }
        }

        System.out.println(ans);
    }
}
