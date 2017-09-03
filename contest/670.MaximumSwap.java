// Problem 670 Maximum Swap

// Unfinished
class Solution {
    public int maximumSwap(int num) {
        if(num < 10)
            return num;
        int count = 0;
        while(num != 0) {
            count++;
            num /= 10;
        }
        int []nums = new int[count];
        int i = 0;
        while(num != 0) {
            nums[i] = num % 10;
            i++;
            num /= 10;
        }
        int []newArray = nums.clone();
        Arrays.sort(newArray);
        return compare(nums, newArray);
    }
    
    public int compare(int[] nums, int[] newArray) {
        if(nums[nums.length - 1] >= newArray[newArray.length - 1]) {
            if(nums.length - 1 > 0)
                return compare(Arrays.copyOfRange(nums, 0, nums.length - 1), Arrays.copyOfRange(newArray, 0, nums.length - 1));
        }
        else {
            int tmp = nums[nums.length - 1];
            int j = 0;
            for(int m = 0; m < nums.length; m++) {
                if(nums[m] == newArray[nums.length - 1])
                    j = m;
            }
            nums[nums.length - 1] = newArray[nums.length - 1];
            nums[j] = tmp;            
        }
        int res = 0;
        for(int l = nums.length - 1; l >= 0; l--) {
           res = res * 10 + nums[l];
        }
        return res;
    }
}