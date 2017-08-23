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
