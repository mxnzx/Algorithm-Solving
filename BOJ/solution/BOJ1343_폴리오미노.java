package solution;

import java.io.*;

public class BOJ1343_폴리오미노 {

    static StringBuilder ans = new StringBuilder();

    static boolean replacePolyomino(int cnt) {

        if(cnt % 2 != 0) return false;

        while(cnt >= 4) {
            ans.append("AAAA");
            cnt -= 4;
        }
        if(cnt == 2) ans.append("BB");
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        char[] input = S.toCharArray();

        int cnt = 0;
        for (int i = 0; i < input.length; i++) {
            if(input[i] == 'X') cnt++;
            else {
                if(!replacePolyomino(cnt)) {
                    System.out.println(-1);
                    return;
                } else {
                    cnt = 0;
                    ans.append(".");
                }
            }
        }

        if(!replacePolyomino(cnt)) {
            System.out.println(-1);
            return;
        }

        System.out.println(ans);

    }
}
