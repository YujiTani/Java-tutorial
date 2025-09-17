import java.util.PriorityQueue;
import java.util.Collections;

public class Solution {
    // TODO: Implement solution here
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        int[] numbers = {1,2,3,4,5,6,6,7,7,8,8,10,22,11,13,34,56,19,294,3,25,256,45,78,61,32};

        for(int i : numbers) {
            minHeap.offer(i);
        }

        System.out.println(minHeap);
        System.out.println(minHeap.peek());
        System.out.println(minHeap.size());
        System.out.println(minHeap.isEmpty());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.size());
        minHeap.clear();
        System.out.println(minHeap.isEmpty());
        System.out.println(minHeap.size());

    }
}
