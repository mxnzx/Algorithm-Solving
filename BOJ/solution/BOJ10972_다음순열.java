/*

 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10972_다음순열 {

	static int N;
	static int[] input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		input = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		//이미 내림차순으로 정렬되어있으면 -1 출력하게 flag 줌
		boolean flag = true;
		for (int i = 1; i < N; i++) {
			if(input[i-1] >= input[i]) continue;

			flag = false;
			break;
		}

		if(!flag) {
			//오름차순 정렬 전처리
			//Arrays.sort(input);
			np(input);
			//System.out.println(Arrays.toString(input));
			for (int i :
					input) {
				sb.append(i + " ");
			}
		} else {
			sb.append(-1);
		}
		System.out.println(sb);
		br.close();


	}
	private static boolean np(int[] input) {

		int n = input.length;

		//1. 뒤쪽부터 꼭대기를 찾는다.
		int i = n - 1;
		while(i>0 && input[i] <= input[i-1]) i--;
		if(i == 0) return false;

		//2. 꼭대기 바로 앞자리와 그 자리값보다 한단계 큰 자리를 수를 뒤부터 찾는다
		int j = n - 1;
		while(input[i-1] >= input[j]) j--;

		//3. 꼭대기 바로 앞자리와 그 자리값보다 한단계 큰 자리를 수와 교환한다.
		swap(input, i-1, j);

		//4. 꼭대기부터 맨 뒤까지 오름차순으로 정렬한다
		int k = n - 1;
		while(i<k)
			swap(input, i++, k--);

		return true;
	}

	private static void swap(int[] arr, int a, int b){
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}



}
