// Problem 737 Sentence Similarity II

// method 1: use union-find
class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        HashMap<String, String> graph = new HashMap<>();
        if (words1.length != words2.length) return false;
        for (String[] pair : pairs) {
            String parent1 = find(graph, pair[0]);
            String parent2 = find(graph, pair[1]);
            if (!parent1.equals(parent2))
                graph.put(parent1, parent2);
        }
        for (int i = 0; i < words1.length; i++) {
            if (!words1[i].equals(words2[i]) && !find(graph, words1[i]).equals(find(graph, words2[i])))
                return false;
        }
        return true;
    }
    
    private String find(HashMap<String, String> graph, String str) {
        if (!graph.containsKey(str))
            graph.put(str, str);
        return str.equals(graph.get(str))? str : find(graph, graph.get(str));
    }
}

// method 2: use dfs
class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for (String[] pair : pairs) {
            if (!map.containsKey(pair[0]))
                map.put(pair[0], new HashSet<String>());
            if (!map.containsKey(pair[1]))
                map.put(pair[1], new HashSet<String>());
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }
        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i]))
                continue;
            if (!map.containsKey(words1[i]))
                return false;
            if (!helper(words1[i], words2[i], map, new HashSet<String>()))
                return false;
        }
        return true;
    }
    private boolean helper(String source, String target, HashMap<String, HashSet<String>> map, HashSet<String> visited) {
        if (map.get(source).contains(target)) return true;
        visited.add(source);
        for (String next : map.get(source)) {
            if (!visited.contains(next) && helper(next, target, map, visited))
                return true;
        }
        return false;
    }
}