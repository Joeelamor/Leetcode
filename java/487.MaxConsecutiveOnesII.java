// Question 487 Max Consecutive Ones II

// Method 1:
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
// Method 2: 

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, pre = -1, cur = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Math.max(max, i - pre - 1);
                pre = cur;
                cur = i;
            }
        }
        return Math.max(max, nums.length - pre - 1);
    }
}