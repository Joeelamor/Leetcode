// Problem 46 Permutations

// Use backtracking
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTracking(nums, res, new ArrayList<>());
        return res;
    }
    public void backTracking(int[] nums, List<List<Integer>> res, List<Integer> list) {
        if (list.size() == nums.length)
            res.add(new ArrayList<>(list)); 
        else {
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i]))
                    continue;
                list.add(nums[i]);
                backTracking(nums, res, list);
                list.remove(list.size() - 1);
            }
        }
    }
}