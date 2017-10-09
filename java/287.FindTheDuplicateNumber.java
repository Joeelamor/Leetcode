// Problem 287 Find The Duplicate Number

// Method 1: O(1) space using Binary Search
class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int n : nums) {
                if (n <= mid)
                    count++;
            }
            if (count <= mid)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
}

// Method 2: O(1) space O(n) time

/* Use the linkedlist cycle method to solve this problem, the first time slow = fast,
 * we can obtain an intersection point in the circle, and set the fast to 0, in the second time,
 * we get the repeated number in this array.
 *   o ------1-----> o1 -------2------- o2
 *                   |                  |
 *                    --------3---------
 * From above figure, we can see that after the first meet at o2, we have l1 + l2 + l3 + l2 = 2 * (l1 + l2),
 * so we have l1 = l3, then set fast to o, slow at o2, keeping move this two point in same speed, they will
 * meet at o2 at the same time, and finally we will know the duplicate number.
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}