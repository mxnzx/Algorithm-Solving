package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2607_비슷한단어 {
    static String target, input;
    static char[] targetToArr, inputToArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        target = br.readLine();
        int[] targetArr = new int[26];
        for (int i = 0; i < target.length(); i++) {
            targetArr[target.charAt(i) - 'A']++;
        }

        int result = 0;
        for (int i = 0; i < N - 1; i++) {
            input = br.readLine();
            if (check(Arrays.copyOf(targetArr, targetArr.length))) result++;
        }
        System.out.println(result);

//        targetToArr = target.toCharArray();
//        Arrays.sort(targetToArr);
//        target = String.valueOf(targetToArr);
//        int cnt = 0;
//
//        for (int i = 0; i < N - 1; i++) {
//            input = br.readLine();
//
//            if (checkComposition()) {
//                cnt++;
//                System.out.println(input);
//                continue;
//            }
//            if (checkSimilar()) {
//                cnt++;
//                System.out.println(input);
//            }
//        }
//        System.out.println(cnt);

    }

    private static boolean check(int[] targetArr) {
        int cnt = 0;
        int targetLen = target.length();
        int inputLen = input.length();
        for (int i = 0; i < input.length(); i++) {
            if (targetArr[input.charAt(i) - 'A'] > 0) {
                cnt++;
                targetArr[input.charAt(i) - 'A']--;
            }
        }


        if (targetLen == inputLen && (targetLen == cnt || targetLen - 1 == cnt)) {
            return true;
        }
        if (targetLen - 1 == inputLen && inputLen == cnt) {
            return true;
        }
        if (targetLen + 1 == inputLen && inputLen - 1 == cnt) {
            return true;
        }
        return false;


    }

    private static boolean checkSimilar() {
        int targetLen = targetToArr.length;
        int inputLen = inputToArr.length;

        if (targetLen == inputLen) {
            for (int i = 0; i < targetLen; i++) {
                if (targetToArr[i] != inputToArr[i]) {
                    return target.substring(i + 1).equals(input.substring(i, inputLen - 1)) ||
                            target.substring(i, targetLen - 1).equals(input.substring(i + 1));
                }
            }
        } else if (targetLen + 1 == inputLen) {
            for (int i = 0; i < targetLen; i++) {
                if (targetToArr[i] != inputToArr[i]) {
                    return target.substring(i).equals(input.substring(i + 1));
                }
            }

        } else if (targetLen - 1 == inputLen) {
            for (int i = 0; i < inputLen; i++) {
                if (targetToArr[i] != inputToArr[i]) {
                    return target.substring(i + 1).equals(input.substring(i));
                }
            }
        } else {
            return false;
        }

        return true;
    }

    private static boolean checkComposition() {
        inputToArr = input.toCharArray();
        Arrays.sort(inputToArr);
        input = String.valueOf(inputToArr);

        if (targetToArr.length != inputToArr.length) return false;

        for (int i = 0; i < targetToArr.length; i++) {
            if (targetToArr[i] != inputToArr[i]) return false;
        }
        return true;

    }

}
