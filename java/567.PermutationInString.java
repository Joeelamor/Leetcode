// Problem 567 Permutation In String

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;
        int[] arr = new int[26];
        for (int i = 0; i < len1; i++) {
            arr[s1.charAt(i) - 'a']++;
            arr[s2.charAt(i) - 'a']--;
        }
        if (helper(arr)) return true;
        for (int i = len1; i < len2; i++) {
            arr[s2.charAt(i) - 'a']--;
            arr[s2.charAt(i - len1) - 'a']++; // add before element back which matches arr[s2.charAt(i) - 'a']--;
            if (helper(arr)) return true;
        }
        return false;
        
    }
    private boolean helper(int[] arr) {
        for (int i : arr) {
            if (i != 0)
                return false;
        }
        return true;
    }
}