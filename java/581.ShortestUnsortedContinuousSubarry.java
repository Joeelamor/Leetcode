// Problem 581 Shortest Unsorted Continuous Subarray

// Method 1: use Arrays.sort() function to sort nums[], O(nlogn) time.
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int []tmp = new int[len];
        for(int i = 0; i < len; i++) 
            tmp[i] = nums[i];
        Arrays.sort(tmp);
        int start = 0, end = len - 1;
        while(start < len && tmp[start] == nums[start])
            start++;
        while(end > start && tmp[end] == nums[end])
            end--;
        return end - start + 1;
    }
}

// Method 2: O(n) time
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length, start = -1, end = -2, min = nums[n -1], max = nums[0];
        for(int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - i - 1]);
            if(nums[i] < max)
                end = i;
            if(nums[n - i - 1] > min)
                start = n - i - 1;
        }
        return end - start + 1;
    }
}
