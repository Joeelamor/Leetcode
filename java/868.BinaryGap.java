// Problem 868 Binary Gap

class Solution {
    public int binaryGap(int N) {
        int res = 0, pos = 0, lastIndex = -1;
        while (N > 0) {
            pos++;
            if ((N & 1) == 1) {
                if (lastIndex != -1)
                    res = Math.max(res, pos - lastIndex);
                lastIndex = pos;
            }
            N >>= 1;
        }
        return res;
    }
}