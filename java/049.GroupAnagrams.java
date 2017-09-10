// Problem 49 Group Anagrams

/* Use a hashMap to keep key string and its anagrams list. Then add the list to
 * the final list result. */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0) return res;
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s: strs) {
            char []c = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if(!map.containsKey(key))
                map.put(key, new ArrayList<String>());
            map.get(key).add(s);
        }
        res = new ArrayList<List<String>>(map.values());
        return res;
    }
}