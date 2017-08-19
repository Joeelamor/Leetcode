// Problem 520 Detect Capital

class Solution {
    public boolean detectCapitalUse(String word) {
        int countUp = 0, countLow = 0;
        for(int i =0; i < word.length(); i++) {
            if(word.charAt(i) - 'Z' > 0)
                countLow++;
            else
                countUp++;
        }
        if(countLow == word.length())
            return true;
        else if(countUp == word.length())
            return true;
        else if(countLow == word.length() - 1 && word.charAt(0) - 'Z' < 0)
            return true;
        else
            return false;
    }
}