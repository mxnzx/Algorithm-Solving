/*
 * BOJ2493: 탑
 * 구현 - 자료구조 스택
 * 막힌 부분: 값을 받아오면서 처리하는 것을 생각하지 못함
 * 막힌 부분2: 값을 비교해서 불필요한 값들은 미리 pop해놓으면(처리해놓으면) 편함
 * 막힌 부분3: 스택의 자료형을 배열로 할 생각을 못함 - 클래스로 만들어도 가능할듯? 안되면 스택하나 더 만들어서 인덱스와 높이를 따로 처리해주어야 함.
 * 전체적으로 못풀었던 문제. 다시 풀 때 구현할 줄 알기
 */

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
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		Stack<int[]> s = new Stack<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			//현재 받은 값의 탑 높이
			int current = Integer.parseInt(st.nextToken());

			while(!s.isEmpty()) {
				//이전 탑의 높이가 현재 높이보다 작으면 이전 탑 pop
				if(s.peek()[1] < current) {
					s.pop();
				} else {
					//이전 탑의 높이가 현재보다 크게되면 수신하므로 이전 탑의 인덱스 출력
					sb.append(s.peek()[0]).append(" ");
					break;
				}
			}
			//스택이 비었으면
			if(s.isEmpty()) {
				sb.append("0 ");
			}
			//현재 탑의 인덱스와 높이를 스택에 넣는다
			s.push(new int[] {i, current});
		}
		System.out.println(sb);

	}

}
