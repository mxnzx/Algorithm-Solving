package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1486_장훈이의높은선반 {
	static int T, N, B;
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
			min = Integer.MAX_VALUE;
			st= new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			//만족하는 S의 최솟값을 찾는 문제(필요한 점원의 명수는 고려하지 않는다)
			//B보다는 커야하지만 그 중 제일 작은 수 - 순조부같은데
			
			//부분집합
			//다~~~~~~~~~구하자

			//부분집합 - 조합을 반복해서
			for (int i = 0; i <= N; i++) {
				comb(0,0, i, 0);
			}
			sb.append("#").append(tc).append(" ").append(min).append("\n");
			
		}
		System.out.println(sb);
		
		

	}
	static int min;
	//조합 idx: 원본배열 인덱스  k:뽑은 개수  choiceNum: 선택해야하는 개수  sum: 합계
	private static void comb(int idx, int k, int choiceNum, int sum) {
		
		if(k == choiceNum) {
			//뽑으려는 개수만큼 뽑혔다면 B값을 넘겼는지 체크하고 최솟값 비교하고 갱신
			if(sum>=B) min = Math.min(sum-B, min);
			return;
		}
		//원본배열 인덱스가 배열 끝까지 돌았다면 리턴
		if(idx == height.length) return;
		if(min == 0) return;
		
		//고르는 경우
		comb(idx+1, k+1, choiceNum, sum+height[idx]);
		//안고르는 경우
		comb(idx+1, k, choiceNum, sum);
	}

}
