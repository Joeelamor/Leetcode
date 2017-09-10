// Problem 673 Number Of Longest Increasing Subsequence

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int res = 0, maxLen = 0;
        // Use two DP array to record max length and max count of current index. 
        int []count = new int[nums.length];
        int []len = new int[nums.length];
        // First point move left to right.
        for(int i = 0; i < nums.length; i++) {
            // Default all count and length 1.
            count[i] = 1;
            len[i] = 1;
                // second point from left to first point.
                for(int j = 0; j < i; j++) {
                    if(nums[i] > nums[j]) {
                        if(len[i] == len[j] + 1)
                            count[i] += count[j];
                        if(len[i] < len[j] + 1) {
                            len[i] = len[j] + 1;
                            count[i] = count[j];
                        }
                    }
                }
            if(maxLen == len[i])
                res += count[i];
            if(maxLen < len[i]) {
                maxLen = len[i];
                res = count[i];
            }
        }
        return res;
    }
s