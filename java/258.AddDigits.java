// Problem 258 Add Digits

// Method 1: Iteration
public class Solution {
    public int addDigits(int num) {
        while(num > 9) {
            int tmp = 0;
            while(num > 0) {
                tmp += num % 10;
                num /= 10;
            }
            num = tmp;
        }
        return num;
    }
}

/* Method 2: Digital Root
 * this method depends on the truth:
 * N=(a[0] * 1 + a[1] * 10 + ...a[n] * 10 ^n),and a[0]...a[n] are all between [0,9]
 * we set M = a[0] + a[1] + ..a[n] and another truth is that:
 * 1 % 9 = 1
 * 10 % 9 = 1
 * 100 % 9 = 1
 * so N % 9 = a[0] + a[1] + ..a[n]
 * means N % 9 = M
 * so N = M (% 9)
 * as 9 % 9 = 0,so we can make (n - 1) % 9 + 1 to help us solve the problem when n is 9.as N is 9, ( 9 - 1) % 9 + 1 = 9 */
public class Solution {
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}