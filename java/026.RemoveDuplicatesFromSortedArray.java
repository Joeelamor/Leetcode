// Problem 26 Remove Duplicates from Sorted Array

/* remember constant memory means that it only allows change number in array and 
 * outputs the changed array by length of index. This answer uses a subtle way of
 * changing positions. */

public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 1; j < nums.length; j++) {
            if(nums[i] == nums[j])
                continue;
            else {
                nums[i+1] = nums[j];
                i++;
            }
        }
        return i+1;
    }
}