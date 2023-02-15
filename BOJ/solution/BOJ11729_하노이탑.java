/*
 * [BOJ]11729. 하노이탑 이동 순서
 * 재귀 - 플랫하게 보아라. 뭐가 반복되는지를 보고 그대로 코드로 구현만 하면된다. 따라가려고 하지 마!!!!!
 * 하노이탑 옮긴 횟수 수학적 귀납법 도출 = 2^n-1 번이다. 참고로 알아두자~
 */
package solution;

import java.util.Scanner;

public class BOJ11729_하노이탑 {

	static StringBuilder sb;
	static int K, cnt;
	
	public static void main(String[] args) {
		sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		
		cnt = 0;
		hanoi(K,1,2,3);
		sb.insert(0, cnt + "\n");
		System.out.println(sb);

	}
	/*
	 * K : 원판의 개수
	 * arr: 출발지
	 * mid: 이동 장소
	 * des: 목적지
	 */
	private static void hanoi(int K, int arr, int mid, int des) {
		
		//한 번 호출할 때 마다 카운트를 늘려준다.
		cnt++;
		
		if(K == 1) {
			sb.append(arr + " " + des+"\n");
			return;
		}
		
		//K-1개를 A에서 B로 이동 (= arr 지점의 K-1개의 원판을 mid지점으로 옮긴다.)
		hanoi(K-1, arr, des, mid);
		
		//1개를 A에서 C로 이동 (= arr 지점의 K번째 원판을 des지점으로 옮긴다.)
		sb.append(arr + " " + des + "\n");
		
		//K-1개를 B에서 C로 이동 (= mid지점의 K-1개의 원판을 des지점으로 옮긴다.)
		hanoi(K-1, mid, arr, des);

	}

}
