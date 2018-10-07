// Question 689 Maximum Sum of 3 Non-Overlapping Subarrays

class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] arr = new int[nums.length - k + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k)
                sum -= nums[i - k];
            if (i >= k - 1)
                arr[i - k + 1] = sum;
        }
        
        int[] left = new int[arr.length];
        int best = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[best]) 
                best = i;
            left[i] = best;
        }
        
        int[] right = new int[arr.length];
        best = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > arr[best])
                best = i;
            right[i] = best;
        }
        
        int[] res = {-1, -1, -1};
        for (int second = k; second < arr.length - k; second++) {
            int first = left[second - k], third = right[second + k];
            if (res[0] == -1 || arr[first] + arr[second] + arr[third] > arr[res[0]] + arr[res[1]] + arr[res[2]]) {
                res[0] = first;
                res[1] = second;
                res[2] = third;
            }
        }
        return res;
    }
}