// Problem 698 Partition to K Equal Sum Subsets

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (k <= 0 || sum % k != 0) 
            return false;
        boolean []visited = new boolean[nums.length];
        return help(nums, k, visited, sum / k, 0, 0, 0);
    }
    public boolean help(int[] nums, int k, boolean[] visited, int target, int start, int curSum, int curNum) {
        if (k == 1)
            return true;
        if (target == curSum && curNum > 0) {
            return help(nums, k - 1, visited, target, 0, 0, 0);
        }
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (help(nums, k, visited, target, i + 1, curSum + nums[i], curNum + 1))
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }
}