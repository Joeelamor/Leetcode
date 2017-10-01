// Problem 686 Repeated String Match

class Solution {
    public int repeatedStringMatch(String A, String B) {
        int lenA = A.length(), lenB = B.length();
        if (A.contains(B))
            return 1;
        StringBuilder C = new StringBuilder(A);
        int len = lenA;
        while (len < 3 * lenB) {
        	// If C doesn't contain B, then last index of B is -1.
            if (C.toString().lastIndexOf(B) != -1)
                return len / lenA;
            C.append(A);
            len = C.length();
        }
        return -1;
    }
}