// Question 487 Max Consecutive Ones II

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        int res = 0, k = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                q.offer(j);
            } 
            while (q.size() > k) {
                i = q.poll() + 1;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}