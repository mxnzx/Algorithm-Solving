package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14405_피카츄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        S = S.replace("pi"," ");
        S = S.replace("ka"," ");
        S = S.replace("chu"," ");

        S = S.trim();
        //위말고 replaceAll로 한번에 할 수 있다
        //S = S.replaceAll("pi|ka|chu","");
        if(S.equals("")) System.out.println("YES");
        else System.out.println("NO");
    }
}
