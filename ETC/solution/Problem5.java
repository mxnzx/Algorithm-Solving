package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem5 {

    //static char[] c = {'A','B','C','D','E','F','G','H'};
    //static String[] num = new String[]{"000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010"};

    // 힌글자 다른 거 처리
//    static String replaceSim() {
//        return ;
//    }ß

    //해당 글자가 있으면 ans배열에 하나씩 추가한다. 없을 시 해당 idx를 리턴.
    //한글자 다를 경우를 고려 못함.
    static String replace(int n, String[] arr) {
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {

            switch (arr[i]) {
                case "000000":
                    ans[i] = 'A';
                    break;
                case "001111":
                    ans[i] = 'B';
                    break;
                case "010011":
                    ans[i] = 'C';
                    break;
                case "011100":
                    ans[i] = 'D';
                    break;
                case "100110":
                    ans[i] = 'E';
                    break;
                case "101001":
                    ans[i] = 'F';
                    break;
                case "110101":
                    ans[i] = 'G';
                    break;
                case "111010":
                    ans[i] = 'H';
                    break;
                default:
                    return String.valueOf(i + 1);

            }
        }
        String ansString = String.join("", String.valueOf(ans));
        return ansString;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    //보낸 문자의 개수
        String str = br.readLine();     //보낸 문자

//        // 보낸 문자를 배열에 하나씩 넣자
//        char[] strToChar = str.toCharArray();
//
//        char[][] arr = new char[n][6];    //각 배열에 한 문자(6개의 열)가 들어감
//        for (int i = 0; i < n; i++) {
//            //0-5 6-11 12-17
//            System.arraycopy(strToChar, i, arr[i], 0, 6);
//        }

        // 문자열타입 배열에 문자열을 잘라서 한 문자씩 넣는다
        String[] arr = new String[n];
        for (int i = 0; i < str.length(); i+=6) {
            arr[i/6] = str.substring(i,i+6); //0-5,6 6-11,12
        }
        // 단어를 치환하는 함수에 전달.
        String ans = replace(n,arr);

        System.out.println(ans);


    }
}
