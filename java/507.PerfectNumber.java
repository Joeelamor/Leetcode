// Problem 507 Perfect Number

class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num <= 1)
            return false;
        int sum = 0;
        for(int i = 1; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                if(i * i != num)
                    sum += i + num/i;
                else
                    sum += i;
            }             
        }
        return sum == 2 * num;
    }
}