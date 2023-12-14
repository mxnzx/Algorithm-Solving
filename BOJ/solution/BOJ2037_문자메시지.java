package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2037_문자메시지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());    //버튼 한번 누르는데 걸리는 시간
        int w = Integer.parseInt(st.nextToken());    //같은 숫자인 문자 찍기위해 기다리는 시간
        char[] input = br.readLine().toCharArray();
        int time = 0;
        for (int i = 0; i < input.length; i++) {
            //이전입력과 내가 같은 숫자를 눌러야하는지 체크
            char c = input[i];
            if(c == ' ') {
                time += p;
                continue;
            }
            //A=65 66 67 -> 얘네는 +1 해서 66 67 68 로 만들고 3으로 나누면 몫이 같음.
            // 몫으로 비교하고, 나머지로 시간 체크
            int charToInt = (int) c;
            if(charToInt < 80) { //6번까지
                time += (((charToInt+1) % 3) + 1) * p;
                if(i != 0 && input[i-1] != ' ' && (((int)input[i-1]) + 1) / 3 == (charToInt+1) / 3) time += w;
            } else {
                if(charToInt < 84) {
                    // 80 81 82 83
                    time += (charToInt - 80 + 1) * p;
                    if(i != 0 && input[i-1] != ' ' && (int)input[i-1] >= 80 && (int)input[i-1] < 84) time += w;
                } else if(charToInt < 87) {
                    // 84 85 86
                    time += (charToInt - 84 + 1) * p;
                    if(i != 0 && input[i-1] != ' ' && (int)input[i-1] >= 84 && (int)input[i-1] < 87) time += w;
                } else {
                    // 87 88 89 90
                    time += (charToInt - 87 + 1) * p;
                    if(i != 0 && input[i-1] != ' ' && (int)input[i-1] >= 87 && (int)input[i-1] < 91) time += w;
                }
            }
        }
        System.out.println(time);
    }
}
