// Problem 018 4Sum

// Modify the code based on 3Sum
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i + 3 < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            if(4 * nums[i] > target) break;
            if(nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) continue;
            for(int j = i + 1; j + 2 < nums.length; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if(3 * nums[j] > target - nums[i]) break; 
                if(nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target) continue;
                int num = target - nums[i] - nums[j];
                int k = j + 1, l = nums.length - 1;
                while(k < l) {
                    if(nums[k] + nums[l] == num) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while(k < l && nums[k] == nums[k - 1])
                            k++;
                        while(k < l && nums[l] == nums[l + 1])
                            l--;
                    }
                    else if(nums[k] + nums[l] > num)
                        l--;
                    else
                        k++;  
                }
            }
        }
        return res;
    }
}