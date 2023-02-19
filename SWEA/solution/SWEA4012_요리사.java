/*
 * [SWEA]4012. 요리사
 * 순열을 이용해서 식재료를 두 그룹으로 나누어줌. -> 이때 next permutation을 사용했지만 그냥 조합을 이용해 두 그룹을 나누어도 된다.
 *
 *
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4012_요리사 {

	static int T, N, Ans;
	static int[][] map;
	static int[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			check = new int[N]; // 식재료 체크 배열
			Ans = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 식재료 체크를 두 그룹으로 나누는 작업 - next permutation
			// 체크 배열에 뒤 3개에 1을 넣어준다
			for (int i = N / 2; i < N; i++) check[i] = 1;

			do {		//0 0 0 1 1 1
				//System.out.println(Arrays.toString(check));
				//여기서 1인 애들과 0인 애들을 나누어 그룹을 더해준다.
				int sumA = 0;
				int sumB = 0;
				for (int i = 0; i < check.length; i++) {
					for (int j = 0; j < check.length; j++) {
						if(check[i] == 1 && check[j] == 1) { sumA += map[i][j]; }
						if(check[i] == 0 && check[j] == 0) { sumB += map[i][j]; }
					}
				}
				int flavor = Math.abs(sumA-sumB);
				Ans = Math.min(Ans, flavor);
				
			} while(np(check));

			sb.append("#").append(tc).append(" ").append(Ans).append("\n");
		}
		System.out.println(sb);
		br.close();

	}

	// 다음 순열을 가져오는 메소드
	private static boolean np(int[] input) {

		int n = input.length;

		// 1. 뒤쪽부터 꼭대기를 찾는다.
		int i = n - 1;
		while (i > 0 && input[i] <= input[i - 1])
			i--;
		if (i == 0)
			return false;

		// 2. 꼭대기 바로 앞자리와 그 자리값보다 한단계 큰 자리를 수를 뒤부터 찾는다
		int j = n - 1;
		while (input[i - 1] >= input[j])
			j--;

		// 3. 꼭대기 바로 앞자리와 그 자리값보다 한단계 큰 자리를 수와 교환한다.
		swap(input, i - 1, j);

		// 4. 꼭대기부터 맨 뒤까지 오름차순으로 정렬한다
		int k = n - 1;
		while (i < k)
			swap(input, i++, k--);

		return true;
	}

	private static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

}
