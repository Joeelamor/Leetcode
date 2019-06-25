// Question 1078 Occurrences After Bigram

class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        ArrayList<String> res = new ArrayList<>();
        String[] strs = text.split(" ");
        for (int i = 2; i < strs.length; i++) {
            if (first.equals(strs[i - 2]) && second.equals(strs[i - 1]))
                res.add(strs[i]);
        }
        return res.toArray(new String[0]);
    }
}