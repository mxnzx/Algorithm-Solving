/*
 * SWEA1218. 괄호 짝짓기
 * 구현 - 스택.
 * 놓친 부분: 테케 한번 수행 후 스택 초기화 안함.
 * 추가로 찾아본 메소드: 스택에서 특정 문자열이 들어있는 인덱스를 뽑고 (Stack stack.indexOf(String str))
 * 				  그 인덱스를 빼버리는(Stack stack.removeElementAt(int i)) 메서드 두개.
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA1218 {

	static int N, Ans;
	static String str;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		Stack<Character> s = new Stack<>();

		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			str = br.readLine();
			Ans = 0;
			//스택 초기화 !!!!!
			s.clear();
			

			for (int i = 0; i < N; i++) {
				char c = str.charAt(i);
				s.push(c);
				// 조건문을 닫는 괄호로 하나씩 넣어준다
				// 만약에 열린 괄호 짝이 없다면 0을 출력하고 테케 반복문을 중단.
				// 짝이 있으면, 방금 넣어준  닫힌 괄호를 바로 pop하고 내 페어괄호도 pop한다.
				// 다돌고나서 스택 사이즈가 0이면 정답.
				
				switch (c) {
				case '}':
					if(s.contains('{')) {
						s.pop();
						s.removeElementAt(s.indexOf('{'));
					} else {
						
					}
					break;
				case ']':
					if(s.contains('[')) {
						s.pop();
						s.removeElementAt(s.indexOf('['));
					}
					break;
				case ')':
					if(s.contains('(')) {
						s.pop();
						s.removeElementAt(s.indexOf('('));
					}
					break;
				case '>':
					if(s.contains('<')) {
						s.pop();
						s.removeElementAt(s.indexOf('<'));
					}
					break;
				}
				
			}
			//System.out.println(s);
			//스택에 남아있는 괄호가 없으면 0을 출력한다
			if(s.size() == 0) {
				Ans = 1;
			}

			sb.append("#").append(tc).append(" ").append(Ans).append("\n");
		}
		System.out.println(sb);
		br.close();

	}

}
