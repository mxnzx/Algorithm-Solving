/*
 * BOJ12891. DNA 비밀번호
 */
package solution;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class BOJ12891 {

	static int Ans = Integer.MAX_VALUE;
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		String str = sc.next();
		
		arr = new int[4];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(N+" "+M);
		System.out.println(str);
		System.out.println(Arrays.toString(arr));
		
		//해시맵으로 정해진 문자열 만들기
		HashMap<Character, Integer> hs = new HashMap<Character, Integer>();
		hs.put('A',0);
		hs.put('C',0);
		hs.put('G',0);
		hs.put('A',0);
				
		for (int i = 0; i < M; i++) {
		    hs.put(str.charAt(i), hs.get(str.charAt(i))+1);
		}
		
		Set<Character> keys = hs.keySet();
		
		if(check(hs)) Ans++;
		
		//슬라이딩 윈도우
		
		
	}
	//조건에 맞는지 확인
	private static boolean check(HashMap<Character, Integer> hs) {
		// TODO Auto-generated method stub
		
		
		return false;
	}

}
