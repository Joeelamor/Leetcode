// Problem 809 Expressive Words

class Solution {
    public int expressiveWords(String S, String[] words) {
        int res = 0;
        for (String word: words) {
            if (word.length() > S.length()) continue;
            if (word.equals(S)) {
                res++;
                continue;
            }
            int i = 0, j = 0;
            while (i < S.length() && j < word.length()) {
                if (S.charAt(i) == word.charAt(j)) {
                    int index1 = i, index2 = j;
                    char c = S.charAt(i);
                    while (i < S.length() && S.charAt(i) == c) i++;
                    while (j < word.length() && word.charAt(j) == c) j++;
                    if (i - index1 < 3 && !S.substring(index1, i).equals(word.substring(index2, j))) {
                        j--; // This operation is to avoid i == S.length() && j == word.length();
                        break;
                    }
                } else {
                    break;
                }
            }
            if (i == S.length() && j == word.length()) {
                res++;
            }
        }
        return res;
    }
}