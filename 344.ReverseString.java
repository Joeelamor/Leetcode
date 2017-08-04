// Problem 344 Reverse String

public class Solution {
    public String reverseString(String s) {
        char []res = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while(i < j) {
            char temp = res[i];
            res[i] = res[s.length() - 1 - i];
            res[s.length() - 1 - i] = temp;  
            i++;
            j--;
        }
        return new String(res);
    }
}

