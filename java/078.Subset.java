// Problem 78 Subset

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        for(int n : nums) {
            List<List<Integer>> tmp = new ArrayList<>();
            for(List<Integer> sub : res) {
                List<Integer> a = new ArrayList<>(sub);
                a.add(n);
                tmp.add(a);
            }
            res.addAll(tmp);
        }
        return res;
    }
}