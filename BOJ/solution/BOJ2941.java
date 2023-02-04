package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        //하나씩 읽다가 c,d,l,n,s,z 가 나오면 일단 빠진다. 그 다음 입력값을 확인하고 크로아티아 알파벳이면 하나만 올리고, 아니면 두번을 올린다.
        String str = br.readLine();
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            //substring, charAt 다음값 로직 전에 길이 체크 로직을 추가해야 런타임에러 안남
            if(current == 'c') {
                //다음값이 있을 때 =,-이면 카운트 하나, i++
                if( str.length()> i+1 && (str.charAt(i+1) == '=' || str.charAt(i+1) == '-') ) {
                    cnt++;
                    i++;
                } else {
                    cnt++;
                }
            } else if(current == 'd') {
                //다음값이 -이면 카운트 하나, i++
                if( str.length()> i+1 && str.charAt(i+1) == '-' ) {
                    cnt++;
                    i++;

                } else if (str.length()> i+2 && str.startsWith("z=", i+1)) {
                    cnt++;
                    i+=2;
                } else {
                    cnt++;
                }
            } else if (current == 'l' || current == 'n') {
                if( str.length()> i+1 && str.charAt(i+1) == 'j' ) {
                    cnt++;
                    i++;
                } else {
                    cnt++;
                }
            } else if (current == 's' || current =='z') {
                if( str.length()> i+1 && str.charAt(i+1) == '=') {
                    cnt++;
                    i++;
                } else {
                    cnt++;
                }
            } else {
                cnt++;
            }

        }
        System.out.println(cnt);
        br.close();
    }
}
