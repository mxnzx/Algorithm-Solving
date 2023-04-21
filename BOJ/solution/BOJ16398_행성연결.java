package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ16398_행성연결 {
	static class Node {
		int e, c;

		public Node(int e, int c) {
			this.e = e;
			this.c = c;
		}

		public int getC() {
			return c;
		}

	}

	static int[][] matrix;
	static ArrayList<Node>[] adjList;
	static int[] dist;
	static boolean[] v;
	static int N;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		// 인접리스트로 구현
		adjList = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}
		int tmp;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				tmp = Integer.parseInt(st.nextToken());
				if (i >= j)
					continue;
				adjList[i].add(new Node(j, tmp));
				adjList[j].add(new Node(i, tmp));
			}

		}

		v = new boolean[N];
		dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);

		// 인덱스 0번의 노드부터 탐색하며 갱신한다
		dist[0] = 0;
		long sum = prim(new Node(0, 0));

		System.out.println(sum);

	}

	private static long prim(Node start) {
		PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(Node::getC));
		q.add(start);

		long sum = 0;

		while (!q.isEmpty()) {
			Node p = q.poll();

			if (v[p.e]) continue;
			
			v[p.e] = true;
			sum += p.c;
			for (Node next : adjList[p.e]) {
				if (!v[next.e] && dist[next.e] > next.c) {
					dist[p.e] = next.c;
					q.add(next);
				}
			}
		}

		return sum;
	}
}
