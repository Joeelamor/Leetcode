// Problem 788 Rotated Digits

class Solution {
    public int rotatedDigits(int N) {
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (isValid(i)) res++;
        }
        return res;
    }
    
    public boolean isValid(int i) {
        boolean changeFlag = false;
        while (i > 0) {
            if (i % 10 == 2) changeFlag = true;
            if (i % 10 == 5) changeFlag = true;
            if (i % 10 == 6) changeFlag = true;
            if (i % 10 == 9) changeFlag = true;
            if (i % 10 == 3) return false;
            if (i % 10 == 4) return false;
            if (i % 10 == 7) return false;
            i /= 10;
        }
        return changeFlag;
    }
}