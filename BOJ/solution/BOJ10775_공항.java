package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10775_공항 {

	static int G, P, cnt;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		G = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		
		parents = new int[G+1];
		//서로소 집합 - make set
		for (int i = 1; i <= G; i++) {
			parents[i] = i;
		}
		
		for (int i = 0; i < P; i++) {
			int current = Integer.parseInt(br.readLine());
			union(1,current);
			
		}
		System.out.println(Arrays.toString(parents));
		

	}

	private static void union(int i, int current) {
		int pcurrent = find(current);
		
	}

	private static int find(int current) {
		// TODO Auto-generated method stub
		return 0;
	}

}
