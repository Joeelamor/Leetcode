// Question 884 Decoded String At Index

class Solution {
    public String decodeAtIndex(String S, int K) {
        long N = 0;
        int i = 0;
        while (N < K) {
            if (S.charAt(i) >= '0' && S.charAt(i) <= '9') {
                N *= (S.charAt(i) - '0');
            } else {
                N += 1;
            }
            i++;
        }
        i -= 1;
        while (true) {
            if (S.charAt(i) >= '0' && S.charAt(i) <= '9') {
                N /= (S.charAt(i) - '0');
                K %= N;
            } else if (K % N == 0) {
                return "" + S.charAt(i);
            } else {
                N--;
            }
            i--;
        }
    }
}