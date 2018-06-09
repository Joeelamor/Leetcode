// Problem 187 Repeated DNA Sequences

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> res = new HashSet<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            if (!set.add(s.substring(i, i + 10))) {
                res.add(s.substring(i, i + 10));
            }
        }
        return new ArrayList(res);
    }
}