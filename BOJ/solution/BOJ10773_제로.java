package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10773_제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < K; i++) {
            int input = Integer.parseInt(br.readLine());
            //최근 수 저장 최종적은 수의 합 저장
            if(input == 0) {
                sum -= stack.pop();
            } else {
                sum += input;
                stack.push(input);
            }
        }
        System.out.println(sum);
        
    }
}
