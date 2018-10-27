// Problem 215 Kth Largest Element In An Array

/* Method 1: First sort the array and find the Kth largest element.
 * And the sort function is existed. */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

/* Write a quick select function */



/* Use a priority queue to store the numbers, then the first number in queue is what we need*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n: nums) {
            pq.offer(n);
            if(pq.size() > k) {
            pq.poll();
            }
        }
        return pq.peek();        
    }
}


// Method 3: quick select

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) 
            return -1;
        return findKthLargest(nums, 0, nums.length - 1, k);
    }
    
    int findKthLargest(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        
        int mid = start + (end - start) / 2;
        int pivot = nums[mid];
        
        int left = start, right = end;
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        
        if (right - start + 1 >= k) {
            return findKthLargest(nums, start, right, k);
        }
        
        if (k > left - start) {
            return findKthLargest(nums, left, end, k - (left - start));
        }
        
        return nums[right + 1];
    }
}