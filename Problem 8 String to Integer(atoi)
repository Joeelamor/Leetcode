Problem 8 String to Integer(atoi)

public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0)
            return 0;
            str = str.trim();
        int sign = 1;
        int count = 0;
        long sum = 0;
        char firstChar = str.charAt(0);
        if(firstChar == '+') {
            sign = +1;
            count++;
        }
        else if(firstChar == '-') {
            sign = -1;
            count++;
        }
        while(count < str.length() && str.charAt(count) >= '0' && str.charAt(count) <= '9') {
            sum = sum * 10 + (str.charAt(count) - '0');
            count++;
            if(sign == +1 && sum > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(sign == -1 && (-1) * sum < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        return (int)sum * sign;
    }
}