// Problem 624 Maximum Distance In Arrays

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int res = 0, min = arrays.get(0).get(0), max = arrays.get(0).get(arrays.get(0).size() - 1);
        for (int i = 1; i < arrays.size(); i++) {
            if (arrays.get(i).size() == 0) continue;
            else {
                res = Math.max(res, Math.abs(min - arrays.get(i).get(arrays.get(i).size() - 1)));
                res = Math.max(res, Math.abs(max - arrays.get(i).get(0)));
                min = Math.min(arrays.get(i).get(0), min);
                max = Math.max(arrays.get(i).get(arrays.get(i).size() - 1), max);
            }
        }
        return res;
    }
}