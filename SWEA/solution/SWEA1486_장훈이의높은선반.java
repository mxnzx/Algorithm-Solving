package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1486_장훈이의높은선반 {
	static int T, N, B, S;
	static int[] height;

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());	//달성해야 할 높이
			height = new int[N];
			st= new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
				S += height[i];
			}
			System.out.println(S + " " + B);
			//만족하는 S의 최솟값을 찾는 문제(필요한 점원의 명수는 고려하지 않는다)
			//B보다는 커야하지만 그 중 제일 작은 수 - 순조부같은데
			
			//부분집합
			//다~~~~~~~~~구하자
			for (int i = 0; i < N; i++) {
				comb(0,0,new int[i], 0);
			}
			System.out.println(min);
			
		}
		
		

	}
	static int min=Integer.MAX_VALUE;
	private static void comb(int idx, int k, int[] sel, int sum) {
		
		if(k ==sel.length) {
			//System.out.println(sum);
			if(sum>=S) {
				min = Math.min(sum-S, min);
				System.out.println(min);
				
			}
			return;
		}
		if(idx == height.length) {
			return;
		}
		
		//고르는 경우
		comb(idx+1, k+1, sel, sum+height[idx]);
		//안고르는 경우
		comb(idx+1, k, sel, sum);
	}

}
