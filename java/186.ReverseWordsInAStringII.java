// Problem 186 Reverse Words In A String II

// First reverse the string, then reverse each word.
public class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int i = 0, j = 0;
        while(i < s.length) {
            if(s[i] != ' ')
                i++;
            else {
                reverse(s, j, i - 1);
                j = i + 1;
                i++;
            }            
        }
        reverse(s, j, s.length - 1);
    }
    public void reverse(char[] s, int left, int right) {
        while(left < right) {
            char tmp;
            tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}