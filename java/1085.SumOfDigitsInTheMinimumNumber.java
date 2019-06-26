// Question 1085 Sum of Digits in the Minimum Number

class Solution {
    public int sumOfDigits(int[] A) {
        int min = A[0];
        for (int i : A) {
            min = Math.min(min, i);
        }
        int res = 0;
        while (min != 0) {
            res += min % 10;
            min /= 10;
        }
        return res % 2 == 0 ? 1 : 0;
    }
}