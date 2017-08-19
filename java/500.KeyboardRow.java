// Problem 500 Keyboard Row

class Solution {
    public String[] findWords(String[] words) {
        String []row = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < row.length; i++) {
            for(char c: row[i].toCharArray())
                map.put(c, i);
        }
        
        List<String> res = new ArrayList<>();
        for(String word: words) {
            int index = map.get(word.toUpperCase().charAt(0));
            for(char c: word.toUpperCase().toCharArray()) {
                if(map.get(c) != index) {
                    index = -1;
                    break;
                }
            }
            if(index != -1)
                res.add(word);
        }
        return res.toArray(new String[res.size()]);
    }
}