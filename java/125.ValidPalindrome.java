// Problem 125 Valid Palindrome

public class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0)
            return true;
        int head = 0, tail = s.length() - 1;
        while(head < tail) {
            if(!Character.isLetterOrDigit(s.charAt(head)))
                head++;
            else if(!Character.isLetterOrDigit(s.charAt(tail)))
                tail--;
            else {
                if(Character.toLowerCase(s.charAt(head)) != Character.toLowerCase(s.charAt(tail)))
                    return false;
                else {
                    head++;
                    tail--;
                }
            }
        }
        return true;
    }
}