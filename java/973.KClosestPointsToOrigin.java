// Question 973 K Closest Points to Origin

// method 1: priorityqueue O(nlogn)
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] * a[0] + a[1] * a[1] - (b[0] * b[0] + b[1] * b[1])));
        for (int[] point : points) {
            pq.offer(point);
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}

// method 2: divide and conquer, average O(n)

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int lo = 0, hi = points.length - 1;
        while (lo <= hi) {
            int mid = partition(points, lo, hi);
            if (mid == K)
                break;
            if (mid < K)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return Arrays.copyOfRange(points, 0, K);
    }
    int partition(int[][] points, int lo, int hi) {
        int i = lo;
        int[] pivot = points[i];
        while (lo < hi) {
            while (lo < hi && compare(points[hi], pivot) >= 0) hi--;
            while (lo < hi && compare(points[lo], pivot) <= 0) lo++;
            if (lo <= hi) {
                int[] tmp = points[lo];
                points[lo] = points[hi];
                points[hi] = tmp;
            }

        }
        int[] tmp = points[i];
        points[i] = points[lo];
        points[lo] = tmp;
        return lo;
    }
    
    int compare(int[] p1, int[] p2) { 
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}