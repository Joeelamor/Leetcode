// Problem 179 Largest Number

class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        // Use lambda: (a, b) -> (b + a).compareTo(a + b) => make it a descending order
        PriorityQueue<String> pq = new PriorityQueue<>(nums.length, (a, b) -> (b + a).compareTo(a + b));
        for (int i: nums) pq.offer(String.valueOf(i));
        String res = "";
        while(!pq.isEmpty()) {
            res += pq.poll();
        }
        return res.charAt(0) == '0'? "0" : res;
    }
}