// Problem 239 Sliding Window Maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0)
            return new int[0];
        int len = nums.length;
        int []res = new int[len - k + 1];
        // Store index;
        int j = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
        	// If index is not in sliding window, then poll it.
            while (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }
            // Always keep the deque contains element in descending order.
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.offer(i);
            // If the window slides, add a result into final array.
            if (i >= k - 1) {
                res[j] = nums[dq.peek()];
                j++;
            }
        }
        return res;
    }
}