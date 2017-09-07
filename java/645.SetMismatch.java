// Problem 645 Set Mismatch

// O(n) time, O(n) space
class Solution {
    public int[] findErrorNums(int[] nums) {
        int []res = new int[2];
        int []arr = new int[nums.length + 1];
        for(int n: nums) {
            arr[n]++;
        }
        for(int i = 1; i < nums.length + 1; i++) {
            if(arr[i] > 1)
                res[0] = i;
            else if(arr[i] == 0)
                res[1] = i;
        }
        return res;
    }
}