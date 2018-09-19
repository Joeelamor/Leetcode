// Question 218 The Skyline Problem

class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new LinkedList<>();
        List<int[]> heights = new LinkedList<>();
        for (int[] building : buildings) {
            heights.add(new int[]{building[0], -building[2]});
            heights.add(new int[]{building[1], building[2]});
        }
        Collections.sort(heights, (x, y) -> {
            if (x[0] != y[0]) 
                return x[0] - y[0];
            else
                return x[1] - y[1];
            });
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> (y - x));
        pq.offer(0);
        int prev = 0;
        for (int[] height : heights) {
            if (height[1] < 0)
                pq.offer(-height[1]);
            else
                pq.remove(height[1]); // o(n)
            int cur = pq.peek();
            if (prev != cur) {
                res.add(new int[]{height[0], cur});
                prev = cur;
            }
        }
        return res;
    }
}