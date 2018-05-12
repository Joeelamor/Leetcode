// Problem 824 Goat Latin

class Solution {
    public String toGoatLatin(String S) {
        HashSet<Character> set = new HashSet<>();
        for (char c: "aeiouAEIOU".toCharArray()) set.add(c);
        String res = "";
        int i = 0, j = 0;
        for (String str: S.split(" ")) {
            res += ' ' + (set.contains(str.charAt(0))? str : str.substring(1) + str.charAt(0)) + "ma";
            for (i = 0, ++j; i < j; i++) res += "a";
        }
        return res.substring(1);
    }
}	