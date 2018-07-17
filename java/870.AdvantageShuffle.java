// Problem 870 Advantage Shuffle

class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int n = A.length;
        // use pq to store sorted B and its index
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        for (int i = 0; i < n; i++) pq.offer(new int[]{B[i], i});
        int lo = 0, hi = n - 1;
        int[] res = new int[n];
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int index = cur[1], val = cur[0];
            if (A[hi] > val)
                res[index] = A[hi--];
            else
                res[index] = A[lo++];
        }
        return res;
    }
}