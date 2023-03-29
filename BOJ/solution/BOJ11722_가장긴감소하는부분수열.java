package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11722_가장긴감소하는부분수열 {

	static int N;
	static int[] arr, d;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		d = new int[N];
		d[0] = 1;
		Arrays.fill(d,1);
		for(int i=1; i < N; i++) {
			if(arr[i-1] > arr[i]) {
				int max=0;
				for(int j=0; j<=i;j++) {
					d[i] = Math.max(max, d[j]) +1;
				}
			}
			System.out.println(Arrays.toString(d));
		}
		System.out.println(d[N-1]);
		
	}

}
