// Question 395 Longest Substring with At Least K Repeating Characters

class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() == 0)
            return 0;
        int[] arr = new int[26];
        for (char c : s.toCharArray())
            arr[c - 'a']++;
        boolean flag = true;
        for (int i = 0; i < 26; i++) {
            if (arr[i] < k && arr[i] > 0)
                flag = false;
        }
        if (flag)
            return s.length();
        int start = 0, cur = 0, res = 0;
        while (cur < s.length()) {
            if (arr[s.charAt(cur) - 'a'] < k) {
                res = Math.max(res, longestSubstring(s.substring(start, cur), k));
                start = cur + 1;
            }
            cur++;
        }
        res = Math.max(res, longestSubstring(s.substring(start), k));
        return res;
    }
}