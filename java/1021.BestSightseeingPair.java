// Question 1021 Best Sightseeing Pair

class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int res = 0, cur = 0;
        for (int i : A) {
            res = Math.max(res, cur + i);
            cur = Math.max(cur, i) - 1;
        }
        return res;
    }
}