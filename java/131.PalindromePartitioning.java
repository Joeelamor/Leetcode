// Problem 131 Palindrome Partitioning

// Method 1: use backtracking

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0)
            return res;
        partition(s, res, new ArrayList<String>(), 0);
        return res;
    }
    public void partition(String s, List<List<String>> res, List<String> list, int start) {
        if (list.size() > 0 && start >= s.length()) {
            res.add(new ArrayList<String>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrom(s.substring(start, i + 1))) {
                list.add(s.substring(start, i + 1));
                partition(s, res, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
        
    }
    public boolean isPalindrom(String s) {
        if (s.length() == 1)
            return true;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else
                return false;
        } 
        return true;
    }
}
}

// Method 2: use DP

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean [][]dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1]))
                    dp[j][i] = true;
            }
        }
        partition(res, dp, new ArrayList<>(), s, 0);
        return res;
    }
    public void partition(List<List<String>> res, boolean [][]dp, List<String> list, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                list.add(s.substring(start, i + 1));
                partition(res, dp, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}