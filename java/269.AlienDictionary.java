// Question 269 Alien Dictionary

class Solution {
    public String alienOrder(String[] words) {
        HashMap<Character, Integer> degree = new HashMap<>();
        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        String res = "";
        if (words == null || words.length == 0)
            return res;
        for (String word : words) {
            for (char c : word.toCharArray()) 
                degree.put(c, 0);
        }
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            int len = Math.min(cur.length(), next.length());
            for (int j = 0; j < len; j++) {
                char a = cur.charAt(j);
                char b = next.charAt(j);
                if (a != b) {
                    HashSet<Character> set = new HashSet<>();
                    if (map.containsKey(a))
                        set = map.get(a);
                    if (!set.contains(b)) {
                        set.add(b);
                        map.put(a, set);
                        degree.put(b, degree.get(b) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q = new LinkedList<>();
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0)
                q.offer(c);
        }
        while (!q.isEmpty()) {
            char cur = q.poll();
            res += cur;
            if (map.containsKey(cur)) {
                for (char next : map.get(cur)) {
                    degree.put(next, degree.get(next) - 1);
                    if (degree.get(next) == 0)
                        q.offer(next);
                }
            }
        }
        if (res.length() == degree.size())
            return res;
        else
            return "";
    }
}