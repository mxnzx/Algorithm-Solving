package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493_탑 {
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<Integer>();
		Stack<Integer> ans = new Stack<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			s.push(Integer.parseInt(st.nextToken())); //어디에 담을래
		}
		
		//System.out.println(s);
		//System.out.println(s.pop());
		
		//반복문 5번
		for (int i = 0; i < N; i++) {
			//맨 나중것부터 pop해서 top에 집어넣는다
			int top = s.pop();   //4
			System.out.println(s);
			// 하나씩 peek해서 값이 더 크거나 같으면 그 인덱스를 결과 스택에 집어넣는다. ( 먼저 넣은게 맨 나중으로)
			for(int j = 0; j < N-i; j++) {
				int tmp = s.pop();  //7
				if(top <= tmp) {   //4  < 7
					System.out.println(s.indexOf(tmp));
					ans.push(s.indexOf(tmp));
					break;
					
				}
				//System.out.println(ans);
			}
			
			
		}
		
	}

}
