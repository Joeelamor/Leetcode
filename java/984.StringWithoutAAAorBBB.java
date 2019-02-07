// Question 984 String Without AAA or BBB

class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder res = new StringBuilder();
        while (A > 0 || B > 0) {
            boolean writeA = false;
            int L = res.length();
            if (L >= 2 && res.charAt(L - 1) == res.charAt(L - 2)) {
                if (res.charAt(L - 1) == 'b')
                    writeA = true;
            } else {
                if (A >= B)
                    writeA = true;
            }
            if (writeA) {
                A--;
                res.append('a');
            } else {
                B--;
                res.append('b');
            }
        } 
        return res.toString();
    }
}