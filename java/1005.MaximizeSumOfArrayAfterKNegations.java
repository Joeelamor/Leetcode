// Question 1005 Maximize Sum Of Array After K Negations

class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : A)
            pq.offer(i);
        while (K > 0) {
            pq.offer(-pq.poll());
            K--;
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }
}