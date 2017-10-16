// Problem 40 Combination Sum II

// Use backtracking
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(candidates, res, new ArrayList<>(), target, 0);
        return res;
    }
    public void backTracking(int[] candidates, List<List<Integer>> res, List<Integer> list, int remain, int start) {
        if (remain < 0)
            return;
        else if (remain == 0)
            res.add(new ArrayList<>(list));
        else {
            for (int i = start; i < candidates.length; i++) {
                // Skip duplicates
                if (i > start && candidates[i] == candidates[i-1]) 
                    continue; 
                list.add(candidates[i]);
                backTracking(candidates, res, list, remain - candidates[i], i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}