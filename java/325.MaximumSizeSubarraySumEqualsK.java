// Problem 325 Maximum Size Subarray Sum Equals k

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int max = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // if sum equlas to k, then max = i + 1.
            if (sum == k) max = i + 1;
            // if sum - k is in the map, which means there is a k in i - map.get(sum - k).
            else if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
            // use map to store the sum of all elements before index i
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }
}