// Problem 367 Valid Perfect Square

// Method 1: scan 1 to sqrt(num)
public class Solution {
    public boolean isPerfectSquare(int num) {
        for(int i = 1; i <= num/i; i++) {
            if(i*i == num)
                return true;
        }
        return false;
    }
}

// Use mathematic method to solve: all valid perfect square is sum of odd numbers
public class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while(num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
} 
