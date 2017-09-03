// Problem 670 Maximum Swap

// First need to transfer num to a char array, then change the position of two 
// numbers, finally transfer char array to num.
class Solution {
    public int maximumSwap(int num) {
        char []digit = Integer.toString(num).toCharArray();
        int []bucket = new int[10];
        for(int i = 0; i < digit.length; i++) {
            bucket[digit[i] - '0'] = i;
        }
        for(int i = 0 ; i < digit.length; i++) {
            for(int j = 9; j > digit[i] - '0'; j--) {
                if(bucket[j] > i) {
                    char tmp = digit[i];
                    digit[i] = digit[bucket[j]];
                    digit[bucket[j]] = tmp;
                    return Integer.valueOf(new String(digit));
                }
            }
        }
        return num;
    }
}