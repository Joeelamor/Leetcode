// Problem 244 Shortest Word Distance II

class WordDistance {
    HashMap<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i]))
                map.get(words[i]).add(i);
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        for (int num1: map.get(word1)) {
            for (int num2: map.get(word2)) {
                min = Math.min(min, Math.abs(num1 - num2));
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */