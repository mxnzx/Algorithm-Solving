package solution;

import java.util.*;
import java.io.*;

public class BOJ3048_개미 {

    static boolean[] isGroup1 = new boolean[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        char[] group1 = br.readLine().toCharArray();
        char[] group2 = br.readLine().toCharArray();
        int time = Integer.parseInt(br.readLine());

        char[] lines = new char[n1+n2];
        for (int i = 0; i < n1; i++) {
            lines[i] = group1[n1 - 1 - i];
            isGroup1[lines[i] - 'A'] = true;
        }
        for (int i = 0; i < n2; i++) {
            lines[n1 + i] = group2[i];
        }

        while(time-- > 0) {
            char[] tmp = new char[n1+n2];
            int i = 0;
            while(i < n1 + n2 - 1) {
                char now = lines[i];
                if(isGroup1[now - 'A']) {
                    //group1이면 오른쪽 비교
                    char next = lines[i+1];
                    if(isGroup1[next - 'A']) {
                        tmp[i] = lines[i];
                        i++;
                    } else {
                        // change line
                        tmp[i] = lines[i+1];
                        tmp[i+1] = lines[i];
                        i += 2;
                    }
                } else {
                    tmp[i] = lines[i];
                    i++;
                }
                if(i <= n1 + n2 - 1) tmp[n1 + n2 - 1] = lines[n1 + n2 - 1];
            }
            lines = tmp;
        }
        StringBuilder ans = new StringBuilder();
        for(char c : lines) {
            ans.append(c);
        }
        System.out.println(ans);
    }
}
