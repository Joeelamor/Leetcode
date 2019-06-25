// Question 1089 Duplicate Zeros

class Solution {
    public void duplicateZeros(int[] arr) {
        int len = arr.length, noOfShift = 0, i = 0;
        for (i = 0; i + noOfShift < len; i++) {
            noOfShift += arr[i] == 0 ? 1 : 0;
        }
        for (i = i - 1; noOfShift > 0; i--) {
            if (i + noOfShift < len) {
                arr[i + noOfShift] = arr[i];
            }
            if (arr[i] == 0) {
                arr[i + --noOfShift] = arr[i];
            }
        }
    }
}