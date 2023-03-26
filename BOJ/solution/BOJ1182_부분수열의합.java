package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182_부분수열의합 {

	static int N,S,res=0;
	static int[] arr;
	static boolean[] sel;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];
		sel = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//부분집합문제

		//func(0,0);
		func2(0,0);
		if(S == 0) res--;

		System.out.println(res);
	}
	//sum을 하면서 간다(그럼 선택배열이랑 k가 필요가 없게 된다)
	private static void func2(int idx, int sum) {

		if(idx == N) {
			if(sum == S) res++;
			return;
		}
		func2(idx+1,sum+arr[idx]);		//idx원소 포함하면 sum에 넣어
		func2(idx+1,sum);	//안하면 건너뜀
	}

//	//부분집합 고르기
//	private static void func(int idx, int k) {
//		if(idx == arr.length) {
//			checkS();
//			return;
//		}
//
//		sel[idx] = true;
//		func(idx+1,k+1);
//
//		sel[idx]= false;
//		func(idx+1,k);
//
//	}
//	//고른 원소값이 S가 되는지
//	private static void checkS() {
//		int sum=0;
//		boolean flag = false;	//공집합 체크 플래그
//		for (int i = 0; i < N; i++) {
//			if(sel[i]) {
//				sum+=arr[i];
//				flag = true;
//			}
//		}
//		if(!flag) return;
//		if(sum == S) res++;
//	}

}
