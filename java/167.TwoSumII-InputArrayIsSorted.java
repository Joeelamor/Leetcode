// Problem 167 Two Sum II - Input array is sorted.

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int [] indices = new int[2];
        if(numbers.length < 2)
            return indices;
        int left = 0, right = numbers.length - 1;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                indices[0] = left + 1;
                indices[1] = right + 1;
            }
            if(sum < target)
                left++;
            else
                right--;
        }
        return indices;
    }
}