// Problem 804 Unique Morse Code Words

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] strs = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        for (String word: words) {
            String code = "";
            for (char c: word.toCharArray()) {
                code += strs[c - 'a'];
            }
            set.add(code);
        }
        return set.size();
    }
}