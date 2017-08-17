// Problem 448 Find All Numbers Disappeared in an Array

// Use number as index. Use no space and O(N) time.
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0)
                nums[val] = -nums[val];
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0)
                list.add(i + 1);
        }
        return list;
    }
}