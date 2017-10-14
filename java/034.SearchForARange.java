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

// Method 2: Recursive
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] >= target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }

    private int findLast(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }
}

