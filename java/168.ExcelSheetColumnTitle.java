// Problem 168 Excel Sheet Column Title

public class Solution {
    public String convertToTitle(int n) {
        String ans = "";
        while(n>0){
            n--;
            ans = (char)('A' + n % 26) + ans;
            n /= 26;
        }
        return ans;
    }
}