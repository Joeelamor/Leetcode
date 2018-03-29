// Problem 127 Word Ladder

// Method 1: BFS: one end 
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Set<String> set = new HashSet<>();
        for (String s : wordList) {
            set.add(s);
        }
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(endWord)) return level + 1;
                for (int j = 0; j < cur.length(); j++) {
                    char[] word = cur.toCharArray();
                    for (char c = 'a'; c < 'z'; c++) {
                        word[j] = c;
                        String check = new String(word);
                        if (!check.equals(cur) && set.contains(check)) {
                            q.offer(check);
                            set.remove(check);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
