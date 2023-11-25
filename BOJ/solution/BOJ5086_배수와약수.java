package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5086_배수와약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String input;
        while(!(input = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(input);
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if(num2 % num1 == 0) {  //약수
                sb.append("factor").append("\n");
            } else if(num1 % num2 == 0) {   //배수
                sb.append("multiple").append("\n");
            } else {
                sb.append("neither").append("\n");
            }
        }
        System.out.println(sb);
    }
}
