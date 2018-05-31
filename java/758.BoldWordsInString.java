// Problem 758 Bold Words In String

class Solution {
    public String boldWords(String[] words, String S) {
        boolean[] bold = new boolean[S.length() + 1];
        for (String word: words) {
            int start = S.indexOf(word, 0);
            while (start != -1) {
                // The range to be filled extends from index fromIndex, inclusive, to index toIndex, exclusive. 
                Arrays.fill(bold, start, start + word.length(), true);
                start = S.indexOf(word, start + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bold[0]? "<b>" : "");
        for (int i = 0; i < bold.length - 1; i++) {
            sb.append(S.charAt(i));
            if (!bold[i] && bold[i + 1]) sb.append("<b>");
            else if (bold[i] && !bold[i + 1]) sb.append("</b>");
        }
        return sb.toString();
    }
}