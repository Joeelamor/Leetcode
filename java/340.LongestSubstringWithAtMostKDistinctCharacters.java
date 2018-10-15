// Question 340 Longest Substring With At Most K Distinct Characters

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int index = 0, max = 0, count = 0;
        int[] chs = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (chs[s.charAt(i)] == 0)
                count++;
            chs[s.charAt(i)]++;
            while (count > k) {
                chs[s.charAt(index)]--;
                if (chs[s.charAt(index)] == 0)
                    count--;
                index++;
            }
            max = Math.max(max, i - index + 1);
        }
        return max;
    }
}