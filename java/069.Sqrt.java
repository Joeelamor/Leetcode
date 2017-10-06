// Problem 69 Sqrt(x)

/* A stupid and slow method */

public class Solution {
    public int mySqrt(int x) {
        if(x <= 1)
            return x;
        int i;
        for(i = 1; i * i / i == i && i * i <= x; i++);
        return i-1;
    }
}

// Method 2:
class Solution {
    public int mySqrt(int x) {
        int left = 1, right = x, result = 0, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
                result = mid;
            } else 
                right = mid - 1;
        }
        return result;
    }
}