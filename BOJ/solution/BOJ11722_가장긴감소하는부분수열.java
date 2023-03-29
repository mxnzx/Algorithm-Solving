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
		Arrays.fill(d,1);	//초기값을 1로 지정(최소길이 1)
		for(int i=1; i < N; i++) {
			//나(i)보다 왼쪽 애들 중에서 값이 더 큰 애가 있다면,
			for (int j = 0; j <= i-1; j++) {
				if(arr[j] > arr[i]) {
					//그 d값에 +1 한 값과 내 현재 d값을 비교해서 갱신한다
					d[i] = Math.max(d[j]+1,d[i]);
				}
			}
			System.out.println(Arrays.toString(d));
		}
		Arrays.sort(d);
		System.out.println(d[N-1]);
		
	}

}
