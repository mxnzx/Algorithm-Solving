package solution;

import java.util.*;
import java.io.*;

public class BOJ1343_폴리오미노 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        char[] input = S.toCharArray();
        int s = 0;
        int e = 3;
        while(s < input.length) {
            if(input[s] == '.') {
                s++;
                e++;
                continue;
            }
            boolean flag = true;
            if(e >= input.length) flag = false;

            if(flag) {
                for (int i = s; i <= e; i++) {
                    if(input[i] == '.') {
                        flag = false;
                        break;
                    }
                }
            }

            if(!flag) {
                e -= 2;
                flag = true;
                if(e >= input.length) flag = false;
                if(flag) {
                    for (int i = s; i <= e; i++) {
                        if(input[i] == '.') {
                            flag = false;
                            break;
                        }
                    }
                }

                if(!flag) {
                    System.out.println(-1);
                    return;
                } else {
                    for (int i = s; i <= e; i++) {
                        input[i] = 'B';
                    }
                }

            } else {
                for (int i = s; i <= e; i++) {
                    input[i] = 'A';
                }
            }
            s = e + 1;
            e += 4;
        }
        System.out.println(String.valueOf(input));

    }
}
