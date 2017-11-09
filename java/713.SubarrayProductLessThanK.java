// Problem 713 Subarray Product Less Than K

// Just avoid overstepping the boundary
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int product = nums[i];
            if (product < k)
                count++;
            for (int j = i + 1; j < nums.length; j++) {
                product *= nums[j];
                if (product < k)
                    count++;
                else
                    break;
            }
        }
        return count;
    }
}

// method 2: sliding window

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }
}