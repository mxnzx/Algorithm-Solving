/*
 * [BOJ]2839. 설탕배달 - 그리디
 */
package solution;

import java.util.Scanner;

public class BOJ2839_설탕배달 {
	
	static int cnt=-1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	//설탕배달 키로수
		
		//나눌수 있는 수는 3 5 두개다. 더 적은 봉지 개수를 -> BFS 혹은 그리디
		//정확히 되는 값이 아예 없다면 -1 출력
		
		//5로 최대한 나눔 -> 나머지가 3배수가 되는가
		//안될때 마다 5의 봉지를 하나씩 뺌 -> 나머지가 3배수가 되는가
		//그렇게 줄다가 5로 나눈 나머지가 0 일때 -> 3배수가 되는가? - 되면 출력 안되면 -1

		
		int i = N/5;	//N을 5로 나누었을 때의 몫 

		do {
			int n = N - (5*i);	//N을 5로 나누었을 때의 나머지  

			if(n%3 == 0) {
				cnt = i+ (n/3);
				break;
			}
			i--;
			
		} while(i >= 0);
		
		System.out.println(cnt);
		
		

	}

}
