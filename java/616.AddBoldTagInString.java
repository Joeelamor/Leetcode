// Problem 616 Add Bold Tag In String

class Solution {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length() + 1];
        for (String w: dict) {
            int start = s.indexOf(w, 0);
            while (start != -1) {
                Arrays.fill(bold, start, start + w.length(), true);
                start = s.indexOf(w, start + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bold[0]? "<b>" : "");
        for (int i = 0; i < bold.length - 1; i++) {
            sb.append(s.charAt(i));
            if (!bold[i] && bold[i + 1]) sb.append("<b>");
            else if (bold[i] && !bold[i + 1]) sb.append("</b>");
        }
        return sb.toString();
    }
}