// Problem 216 Combination Sum III

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSum(res, new ArrayList<Integer>(), k, n, 1);
        return res;
    }
    private void combinationSum(List<List<Integer>> res, ArrayList<Integer> list, int k, int n, int start) {
        if (list.size() == k && n == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            combinationSum(res, list, k, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }
}