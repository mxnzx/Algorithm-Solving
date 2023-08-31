package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1662_압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        String result = "";
        int resultInt = 0;
        String realResult = "";
        int realResultInt = 0;
        for(char c : arr) {
            if(c != ')') {
                stack.push(c);
            } else {
                // ) 얘가 나오는 순간 ( 이게 나올때 까지 뺀다
                while(true) {
                    char tmp = stack.pop();
                    if(tmp == '(') break;
//                    result += tmp;
                    resultInt++;
                }
                // 그 앞의 K를 뽑는다
                int K = stack.pop() - '0';
                System.out.println(K);
                //result = result.repeat(K);
                //여기서 처리만 해주면 될듯 여기가 result가
//                System.out.println(resultInt);
                resultInt = resultInt * K;

            }
            if(stack.size() == 0)  {
//                realResult += result;
//                result = "";
                realResultInt += resultInt;
                resultInt = 0;
            }
            //System.out.println(stack.size());
//            System.out.println(resultInt);
        }
//        if(stack.size() != 0) realResult = result;
//        System.out.println(realResult.length() + stack.size());
        if(stack.size() != 0) realResultInt = resultInt;
        System.out.println(realResultInt + stack.size());
    }
}
