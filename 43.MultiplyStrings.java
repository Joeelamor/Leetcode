// Problem 43 Multiply Strings

// Method 1: use a string multiply another string bit by bit, need to consider append "0" when use a higher bit.
public class Solution {
    public String multiply(String num1, String num2) {
        if(num1.charAt(0) - '0' == 0 || num2.charAt(0) - '0' == 0)
            return "0";
        String res = "0";
        StringBuilder sb = new StringBuilder();
        for(int i = num1.length() - 1; i >= 0; i--) {
            int carry = 0;
            int product = 0;
            for(int j = num2.length() - 1; j >= 0; j--) {
                if(j >= 0)
                    product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carry;
                sb.append(product % 10);
                carry = product / 10;                
            }
            
            if(carry >0)
                sb.append(carry);           
            sb = sb.reverse();
            
            for(int j = i; j < num1.length() - 1; j++) {
                sb.append('0');
            }
            res = addStrings(sb.toString(), res);
            sb.setLength(0);
        }
        return res;
    }
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

// Method 2: use char array, directly do multiplication and compute sum.
public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] ans = new int[m + n];
        
        for (int i = m - 1; i >= 0; i--){
            for (int j =  n - 1; j >= 0; j--){
                int pro = ((num1.charAt(i) - '0') * (num2.charAt(j) - '0'));
                int temp = ans[i + j + 1] + pro;
                
                ans[i + j + 1] = temp % 10;
                ans[i + j] += temp/10;
            }
        }
        
        StringBuilder res = new StringBuilder();
        for (int t : ans){
            if (res.length() != 0 || t != 0){
                res.append(t + "");
            }
        }       
        return (res.length() == 0)?"0":res.toString();
    }
}


