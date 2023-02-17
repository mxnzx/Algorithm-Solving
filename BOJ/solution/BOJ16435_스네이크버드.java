
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16435_스네이크버드 {

	static int N, L;
	static int[] food;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		food = new int[N];		//음식 담은 배열
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			food[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(food);	//food를 오름차순 10 11 13

		int i=0;
		while(i<food.length) {
			
			//음식을 먹지 못한다면 탈출
			if(food[i] > L) break;
			
			//먹을수있다면 길이를 늘린다. 다음 인덱스가지고 반복
			L++;
			i++;
		}

		System.out.println(L);

	}

}
