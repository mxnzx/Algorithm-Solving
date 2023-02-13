/*
 * [BOJ]1158. 요세푸스 문제
 * 구현 - 자료구조 큐
 * 막힌 부분 : 문제를 너무 어렵게 생각해서 재귀로 풀려고 시간을 많이 잡았다. 간단하게 큐의 poll, offer로 구현가능함.
 * 하다가 아니다 싶으면 다른 방법 한 번 생각해보자
 *
 */


package solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1158_요세푸스1 {

	static int N, K;
	static Queue<Integer> q;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		K = sc.nextInt();
		
		q = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		sb.append("<");
		
		
		while(!q.isEmpty()) {
			for(int i=0; i <K-1; i++) {
				int tmp = q.poll();
				q.offer(tmp);
				//System.out.println(q);
			}
			int n = q.poll();
			if(!q.isEmpty()) {
				sb.append(n + ", ");
			} else {
				sb.append(n);
			}
			
			//System.out.println("poll" +n);	
		}
		sb.append(">");
		System.out.println(sb);
	}
}
