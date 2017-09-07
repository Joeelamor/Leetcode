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