package solution;

import java.util.Scanner;

public class BOJ2231_분해합 {

	static int Ans;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//216
		Ans = 0;
		
		//1부터 N까지 하나씩 탐색한다
		for(int i = 1; i < N; i++) {
			
			String str = String.valueOf(i);
			int sum = i; //1
			for(int j = 0; j<str.length(); j++) {
				sum += str.charAt(j) - '0'; 
			}
			//sum이 N과 같다면 N의 생성자가 되므로 그때의 i가 생성자이다
			if(N == sum) {
				Ans = i;
				break;
			}
		}
		System.out.println(Ans);

	}

}
