// Problem 16 3Sum Closest

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        for(int i = 0; i + 2 < nums.length; i++) {
            // Skip the same numbers.
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            // Traverse the remaining array to find fitting triples.
            int j = i + 1, k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > target)
                    k--;
                else
                    j++;
                if(Math.abs(sum - target) < Math.abs(res - target))
                    res = sum;
            }
        }
        return res;
    }
}
        

