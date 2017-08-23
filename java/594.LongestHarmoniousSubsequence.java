// Problem 594 Longest Harmonious Subsequence

// Use long type is to avoid if 'findLHS(new int[]{-2147483648 , 2147483647})';
//2147483647 + 1 = -2147483648.
class Solution {
    public int findLHS(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        for(long num: nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        int result = 0;
        for(long key: map.keySet()) {
            if(map.containsKey(key + 1))
                result = Math.max(result, map.get(key) + map.get(key + 1));
        }
        return result;
    }
}