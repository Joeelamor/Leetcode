// Problem 10 Regular Expression Matching

// Method 1: use two-dimension array
class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j < dp[0].length; j++) {
            if (p.charAt(j - 1) == '*') {
                if (dp[0][j - 1] || (j > 1 && dp[0][j - 2])) {
                    dp[0][j] = true;
                }
            } 
        }
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } 
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    } 
                } 
            }
        }
        return dp[s.length()][p.length()];
    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j < dp[0].length; j++) {
            if (p.charAt(j - 1) == '*') {
                if (dp[0][j - 1] || (j > 1 && dp[0][j - 2])) {
                    dp[0][j] = true;
                }
            } 
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                    }
                }         
            }
        }
        return dp[s.length()][p.length()];
    }
}

// Method 2: use one-dimension array
class Solution {
    public boolean isMatch(String s, String p) {
        boolean [] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = p.length() - 1;i >= 0; i--) {
            if (p.charAt(i) == '*'){
                for (int j = s.length()-1; j >= 0; j--) {
                    dp[j] = dp[j] || (dp[j + 1] && (s.charAt(j) == p.charAt(i - 1) || p.charAt(i - 1) == '.'));
                }
                i--;
            } else {
                for (int j = 0; j < s.length(); j++){
                    dp[j] = dp[j + 1] && (p.charAt(i) == s.charAt(j) || p.charAt(i) == '.');
                }
                dp[s.length()] = false;
            }
        }
        return dp[0];
    }
}

// Method 3: use recursion

public static boolean isMatch(String s, String t) {
    if (t.length() == 0) {
        return s.length() == 0;
    }
    if (t.length() > 1 && t.charAt(1) == '*') {  
        if (isMatch(s, t.substring(2))) {
            return true;
        }
        if(s.length() > 0 && (t.charAt(0) == '.' || s.charAt(0) == t.charAt(0))) {
            return isMatch(s.substring(1), t);
        }
        return false;
    } else {                                     
        if(s.length() > 0 && (t.charAt(0) == '.' || s.charAt(0) == t.charAt(0))) {
            return isMatch(s.substring(1), t.substring(1));
        }
        return false;
    }
}