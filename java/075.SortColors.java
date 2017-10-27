// Problem 75 Sort Colors

// Two pass
class Solution {
    public void sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                count0++;
            if (nums[i] == 1)
                count1++;
            if (nums[i] == 2)
                count2++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < count0)
                nums[i] = 0;
            else if (i < count0 + count1)
                nums[i] = 1;
            else
                nums[i] = 2;
        }
    }
}

// One pass
class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, index = 0;
        while (index <= right) {
            if (nums[index] == 0) {
                nums[index] = nums[left];
                nums[left] = 0;
                left++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[right];
                nums[right] = 2;
                right--;
                index--;
            }
            index++;
        }
    }
}