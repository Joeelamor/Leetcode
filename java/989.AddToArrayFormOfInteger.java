// Question 989 Add to Array-Form of Integer

class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new LinkedList<>();
        int cur = 0;
        for (int i = A.length - 1; i >= 0 || K != 0 || cur != 0; i--) {
            if (i >= 0)
                cur += A[i];
            if (K > 0) {
                cur += (K % 10);
                K /= 10;
            }
            res.add(0, cur % 10);
            cur /= 10;
        }
        return res;
    }
}