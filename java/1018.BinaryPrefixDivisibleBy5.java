//Question 1018 Binary Prefix Divisible By 5

class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int cur = 0;
        for (int i : A) {
            cur = (cur << 1 | i) % 5;
            res.add(cur == 0); 
        }
        return res;
    }
}