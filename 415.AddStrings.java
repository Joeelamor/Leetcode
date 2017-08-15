// Problem 415 Add Strings

public class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int sum = carry;
            if(i >= 0)
                sum += num1.charAt(i) - '0';
            if(j >= 0)
                sum += num2.charAt(j) - '0';
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }
}