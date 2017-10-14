// Problem 34 Search For A Range

// Method 1: Iterative
class Solution 
{
    public int[] searchRange(int[] nums, int target) 
    {
        int high = nums.length - 1;
        int low = 0;
        int[] res = new int[2];
        
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        while(low < high)
        {
            int mid = low + (high - low) / 2;
            if(target > nums[mid]) low = mid + 1;
            else high = mid;
        }
        if(target == nums[low]) res[0] = low;
        else res[0] = -1;
        
        high = nums.length - 1;
        while(low < high)
        {
            int mid = (low + (high - low) / 2) + 1;
            if(target < nums[mid]) high = mid - 1;
            else low = mid;
        }
        
        if(target == nums[high]) res[1] = high;
        else res[1] = -1;
        
        return res;
    }
}
