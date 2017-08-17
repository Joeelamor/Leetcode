// Problem 13 Roman to Integer

/* in this problem, we need to focus on IV, IX or XL and so on that a smaller number 
 * is before a bigger number. */

public class Solution {
    public int romanToInt(String s) {
        int num[] = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'I')
                num[i] = 1;
            if(s.charAt(i) == 'V')
                num[i] = 5;
            if(s.charAt(i) == 'X')
                num[i] = 10;
            if(s.charAt(i) == 'L')
                num[i] = 50;
            if(s.charAt(i) == 'C')
                num[i] = 100;
            if(s.charAt(i) == 'D')
                num[i] = 500;
            if(s.charAt(i) == 'M')
                num[i] = 1000;
        }
        
        int sum = 0;
        for(int j = 0; j < s.length() - 1; j++) {
            if(num[j] < num[j+1])
                sum = sum - num[j];
            else
                sum = sum + num[j];
        }
        
        return sum + num[s.length() - 1];
    }
}