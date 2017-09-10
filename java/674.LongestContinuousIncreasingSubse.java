// Problem 674 Longest Continuous Increasing Subsequence

// My stupid method.
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        if(nums.length == 2) {
            if(nums[1] - nums[0] < 0)
                return 1;
            else
                return 2;
        }
            
        int max = 0;
        for(int i = 0; i < nums.length - 1;) {
            int j = i + 1;
            int diff = nums[j] - nums[i], count = 0;
            if(diff <= 0){
                i = j;
                continue;
            }
            
            else if(diff > 0) {
                count = 1;
                int k = j + 1;
                while(k < nums.length) {
                    if(nums[k] - nums[k - 1] > 0) {
                        count++;
                        k++;
                    }
                    else
                        break;
                }
                i = j;
            }
            max = Math.max(max, count);
        }
        return max + 1;
    }
}

// Other's smart method
class Solution {
    public int findLengthOfLCIS(int[] nums) {
    	int len = 0;
    	int max = 0;
    	for(int i = 0;i < nums.length;i++){
    		if(i == 0 || nums[i] > nums[i-1]){
    			len++;
    		}else{
    			len = 1;
    		}
    		max = Math.max(max, len);
        }
    	return max;
    }
}	