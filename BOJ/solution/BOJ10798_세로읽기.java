package solution;

import java.util.*;
import java.io.*;

public class BOJ10798_세로읽기 {
    static char[][] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        input = new char[5][15];
        for(int i=0; i<5; i++) {
            Arrays.fill(input[i], '\0');
        }
        for(int i=0; i<5; i++) {
            String str = br.readLine();
            for(int j=0; j<str.length(); j++) {
                input[i][j] = str.charAt(j);
            }
        }
        for(int i=0; i<15; i++) {
            for(int j=0; j<5; j++) {
                if(input[j][i] != '\0') sb.append(input[j][i]);
            }
        }
        System.out.println(sb);
    }
}