// Problem 47 Permutations II

// Use backtracking
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTracking(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }
    public void backTracking(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length)
            res.add(new ArrayList<>(list));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))
                    continue;
                used[i] = true;
                list.add(nums[i]);
                backTracking(nums, res, list, used);
                used[i] = false; 
                list.remove(list.size() - 1);
            }
        }
    }
}