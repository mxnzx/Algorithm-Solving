package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4659_비밀번호발음하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while(!(input = br.readLine()).equals("end")) {
            char[] inputArr = input.toCharArray();
            requirement2(inputArr);
            //aa,ii,uu가 나오지 않으면 통과
            System.out.println(input);
            //세개가 연속되지 않고,
            for (int i = 0; i < ; i++) {

            }
            if(!requirement3(input)) continue;
            if(!req)
            char[] inputArr = input.toCharArray();
            //모음이 존재하고 && 세개가 연속되지 않고
        }
        System.out.println(sb);

    }

    private static void requirement2(char[] inputArr) {
        for (int i = 0; i < inputArr.length; i++) {
            if(inputArr[i]=='a' &&)
        }
    }

    private static boolean requirement3(String input) {
        int originLength = input.length();
        input = input.replace("aa","a");
        input = input.replace("ii","i");
        input = input.replace("uu","u");
        System.out.println(input);
        if(originLength != input.length()) return false;
        return true;
    }
}
