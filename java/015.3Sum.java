// Problem 15 3Sum

// Sorting array will be faster
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // First sort array.
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i + 2 < nums.length; i++) {
            // Skip the same numbers.
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            // Traverse the remaining array to find fitting triples.
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];
            while(j < k) {
                if(nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    // Avoid add same results into final result.
                    while(j < k && nums[j] == nums[j - 1])
                        j++;
                    while(j < k && nums[k] == nums[k + 1])
                        k--;
                }
                else if(nums[j] + nums[k] > target)
                    k--;
                else
                    j++;
            }
        }
        return res;
    }
}