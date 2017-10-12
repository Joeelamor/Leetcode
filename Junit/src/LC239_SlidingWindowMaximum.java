import java.util.ArrayDeque;
import java.util.Deque;

public class LC239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0)
            return new int[0];
        int len = nums.length;
        int []res = new int[len - k + 1];
        // Store index;
        int j = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.offer(i);
            if (i >= k - 1) {
                res[j] = nums[dq.peek()];
                j++;
            }
        }
        return res;
    }

}
