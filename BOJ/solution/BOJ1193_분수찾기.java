package solution;

import java.io.*;
import java.util.*;

public class BOJ1193_분수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());    //천만
        int group = 1;
        int start = 1, end = 1;
        while(true) {
            if(x >= start && x <= end) {
                break;
            }
            group++;
            start = end + 1;
            end = start + group - 1;
        }

        int a = x - start + 1;
        int b = group - (x - start);
        System.out.println(group % 2 == 0 ? a+ "/"+ b : b + "/" + a);




    }
}
