// Problem 207 Contains Duplicate
// Method 1
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        // if(nums.length <= 1)
        //     return false;
        for(int i = 0; i < nums.length; i++) {
            if(hashSet.contains(nums[i]))
                return true;
            else
                hashSet.add(nums[i]);
        }
        return false;
    }
}

// Method 2
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length == 0) return false;
        
        Arrays.sort(nums);
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]) return true;
        }
        
        return false;
    }
}