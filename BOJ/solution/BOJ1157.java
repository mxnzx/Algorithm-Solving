package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        //배열 두개 만들어서 인덱스 똑같이 주고
        char[] upper = new char[26];
        char[] lower = new char[26];
        int[] cnt = new int[26];
        //알파벳 넣어줌
        for (int i = 0; i < 26; i++) {
            upper[i] = (char) (i + (int) 'A');
            lower[i] = (char) (i + (int) 'a');
        }
        //새 배열에다가 카운트 업
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if(input.charAt(i) == upper[j] || input.charAt(i) == lower[j])
                    cnt[j]++;
            }
        }
        //최빈값 구하기
        int max=-1;
        char ans = 0;
        for (int i = 0; i < 26; i++) {
            if(max <= cnt[i]) {       //max보다 해당 cnt가 크면 max값을 바꿔준다. 그 전에 ans를 정해줘야하는데,
                ans = max==cnt[i] ? '?' : upper[i];             //최빈수가 겹치면 ? 출력. 해당 cnt값이 더 크면 해당 인덱스 대문자 출력
                max = cnt[i];
            }
        }
        System.out.println(ans);
    }
}

