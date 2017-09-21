// Problem 678 Valid Parenthesis String

/* Use backtracking: Count each char from left to right. When we see (, count++; when we 
 * see ) count--; if count < 0, it is invalid () is more than (); At last, count should == 
 * 0.This problem added *. The easiest way is to try 3 possible ways when we see it. Return 
 * true if one of them is valid.
 */
class Solution {
    public boolean checkValidString(String s) {
        return check(s, 0, 0);
    }
    public boolean check(String s, int start, int count) {
        if (count < 0)
            return false;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            }
            if (s.charAt(i) == ')') {
                if (count <= 0)
                    return false;
                count--;
            }
            if (s.charAt(i) == '*') {
                return check(s, i + 1, count + 1) || check(s, i + 1, count - 1) || check(s, i + 1, count);
            }
        }
        return count == 0;
    }
}