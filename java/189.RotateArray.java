// 189 Rotate Array

// The first method, O(n) time cost and O(1) space cost.
public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}


// Second method, normal way O(n) time cost, O(k % nums.length) space cost.
public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length <= 1)
            return;
        k = k % nums.length;
        int[] temp = new int[k];
        for(int i = 0; i < k; i++) {
            temp[i] = nums[nums.length - k + i];
        }
        for(int i = nums.length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        for(int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}