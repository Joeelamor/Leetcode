//Question 1017 Convert to Base -2

class Solution {
    public String baseNeg2(int N) {
        String res = "";
        while (N != 0) {
            res = Integer.toString(N & 1) + res;
            N = -(N >> 1);
            System.out.println(Integer.toBinaryString(N));
        }
        return res == ""  ? "0" : res;
    }
}