package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2042_구간합구하기 {

	static int N,M,K;
	static StringBuilder sb = new StringBuilder();
	static long[] arr;
	static double[][] prefixSum;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());		//수의 개수
		M = Integer.parseInt(st.nextToken());		//수의 변경이 일어나는 횟수
		K = Integer.parseInt(st.nextToken());		//구간의 합을 구하는 횟수
		arr = new long[N+1];
		for (int i = 1; i <= N; i++) {			//인덱스 1부터
			arr[i] = Long.parseLong(br.readLine());
		}
		prefixSum = new double[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for(int j=i; j<=N;j++) {
				prefixSum[i][j] = 0.1;
			}
		}
		//M+K번 반복
		for (int i = 0; i < M+K; i++) {
			int a,b,c;
			st = new StringTokenizer(br.readLine());
			a =  Integer.parseInt(st.nextToken());		//a:1 -> arr[b]=c,   a:2 ->arr[b]~arr[c]의 구간합
			b =  Integer.parseInt(st.nextToken());
			c =  Integer.parseInt(st.nextToken());
			
			//입력받으면서 처리
			if(a == 1) changeArr(b,c);
			if(a == 2)  {
				sb.append((long)calSum(b, c)).append("\n");
			}
			
			System.out.println(Arrays.deepToString(prefixSum));
		}
		System.out.println(sb);

	}

	private static double calSum(int b, int c) {
		
		//한번도 연산하지 않았다는 표시값을 어떻게 줄까 ? -> 처음에 소수를 준다?
		if(prefixSum[b][c] != 0.1) return prefixSum[b][c];
		
		for (int i = 1; i <= N; i++) {
			prefixSum[i][i] = arr[i];
		}
		//basis part
		if(b == c) return prefixSum[b][c];
		return prefixSum[b][c] = calSum(b,c-1) + arr[c]; 
		
	}

	private static void changeArr(int b, int c) {
		arr[b]=c;
		
	}

}
