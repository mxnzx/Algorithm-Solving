package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ1655_가운데를말해요 {
    static int N;
    static PriorityQueue<Integer> maxHeap, minHeap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        /*
        우선순위큐를 최대힙, 최소힙 두개의 자료구조를 둔다.
        최대힙, 최소힙 이렇게 있을 때,
        - 두 개의 우선순위큐의 크기가 같을 경우(현재 인덱스가 홀수번째)에는 최대힙에 넣는다.
            ㄴ 이때 인풋값이 최소힙의 최솟값보다 크면 둘을 swap한다.
        - 두 개의 우선순위큐의 크기가 다른 경우(현재 인덱스가 짝수번째)에는 최소힙에 넣는다.
            ㄴ 이때 인풋값이 최대힙의 최댓값보다 작으면 둘을 swap 한다.
        - 결과적으로 최대힙-최소힙을 붙이고 놓으면 이들의 값을 정렬되어 있고, 가운데부터 빠지게 된다.
        - 최대힙의 top이 구하고자하는 중간값이 된다.
         */
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(maxHeap.size() == minHeap.size()) {
                maxHeap.add(input);
                if(!minHeap.isEmpty() && input > minHeap.peek()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(minHeap.poll());
                }
            } else {
                minHeap.add(input);
                if(!maxHeap.isEmpty() && input < maxHeap.peek()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(minHeap.poll());
                }
            }
            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
