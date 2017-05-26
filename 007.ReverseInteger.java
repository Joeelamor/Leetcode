Problem 7 Reverse Integer

public class Solution {
    public int reverse(int x) {
        int result = 0;
        int rest;
        while(x != 0){
            rest = x%10;
            int newResult = result*10 + rest;
            if((newResult-rest)/10 != result)     /* Judge whether it overflows*/
                return 0;
            result = newResult;
            x = x/10;
        }
        return result;
    }
}
