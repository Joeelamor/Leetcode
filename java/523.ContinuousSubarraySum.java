// Problem 523 Continuous Subarray Sum

// Method 1: use brute force 
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        for(int i=0; i<nums.length; i++){
            int sum = nums[i];
            for(int j= i+1; j<nums.length; j++){
                sum += nums[j];
                if(k!=0 && sum % k == 0){
                    return true;
                }else if(k == 0 && sum == 0){
                    return true;
                }
            }
        }
        return false;
    }
}

// Method 2: We iterate through the input array exactly once, keeping track of the 
// running sum mod k of the elements in the process. If we find that a running sum 
// value at index j has been previously seen before in some earlier index i in the 
// array, then we know that the sub-array (i,j] contains a desired sum.
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        int mode = 0;
        int pre = 0;
        for (int i = 0; i < nums.length; ++i) {
            mode += nums[i];
            mode = (k == 0 ? mode : mode % k);
            if (set.contains(mode)) {
                return true;
            }
            set.add(pre);
            pre = mode;
        }
        return false;
    }
}