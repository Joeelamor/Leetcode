// Problem 67 Add Binary

/* In this problem, it is the most important that how to deal with carry problem. */

public class Solution {
    public String addBinary(String a, String b) {
        if(a == null && b == null)
            return "0";
        if(a != null && b == null)
            return a;
        if(a == null && b != null)
            return b;
        int m = a.length() - 1;
        int n = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(m >= 0 || n >= 0) {
            int sum = carry;
            if(m >= 0)
                sum = sum + a.charAt(m--) - '0';
            if(n >= 0)
                sum = sum + b.charAt(n--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if(carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}