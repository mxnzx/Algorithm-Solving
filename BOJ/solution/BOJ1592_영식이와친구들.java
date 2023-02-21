/*
 * [BOJ]1592. 영식이와친구들
 * 구현 시뮬레이션 - 제어문
 */

package solution;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1592_영식이와친구들 {
	static int N,M,L;
	static int[] arr;		//친구마다 카운트
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		
		//받은 횟수 카운트 배열
		arr = new int[N+1];
		
		game(1);	//1번부터 받는다

		//총 카운트는 배열값들의 합
		System.out.println(game(1));
	}

	//p:현재 받은 사람
	private static int game(int p) {
		//일단 받았으면 올린다!
		arr[p]++;
		if(arr[p] == M) {
			//M번 받은 학생이 생기면 중단. 우리가  구하고 싶은 건 공을 던진 횟수이므로 방금 받은 걸 빼고 더한다.
			arr[p]--;
			int cnt=0;
			for (int i : arr) {			
				cnt+=i;
			}
			return cnt; 
		}
		
		//내가 받은 횟수가 짝수이면 시계방향. 원형으로 있으므로 조건 한번 더 나누어주었다
		if(arr[p] % 2 == 0) {	//시계방향
			if(p+L <= N) p = p+L;
			else p = p+L-N;
		} else {	//홀수이면 반시계방향
			if(p-L >= 1) p = p - L;
			else p =p-L+N;
		}
		//다음 차례에게 던진다
		game(p);
		
		return 0;
		
	}
	
	

}
