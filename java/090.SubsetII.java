// Problem 90 Subset II

// Use backtracking
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTracking(nums, res, new ArrayList<>(), 0);
        return res;
    }
    public void backTracking(int[] nums, List<List<Integer>> res, List<Integer> list, int start) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            list.add(nums[i]);
            backTracking(nums, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}