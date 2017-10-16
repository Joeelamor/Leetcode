// Problem 39 Combination Sum

// This is a typical backtracking problem.
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, res, new ArrayList<>(), target, 0);
        return res;
    }
    public void backTrack(int[] candidates, List<List<Integer>> res, List<Integer> list, int remain, int start) {
        if (remain < 0)
            return;
        else if (remain == 0)
            res.add(new ArrayList<>(list));
        else {
            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                backTrack(candidates, res, list, remain - candidates[i], i);
                list.remove(list.size() - 1);
            }
        }
    }
}

