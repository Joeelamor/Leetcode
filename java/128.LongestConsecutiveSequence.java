// Problem 128 Longest Consecutive Sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i: nums) set.add(i);
        int maxLen = 0;
        for (int i: nums) {
            if (set.contains(i)) {
                int len = 1;
                int next = i - 1;
                while (set.contains(next)) {
                    len++;
                    set.remove(next);
                    next--;
                }
                next = i + 1;
                while (set.contains(next)) {
                    len++;
                    set.remove(next);
                    next++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}