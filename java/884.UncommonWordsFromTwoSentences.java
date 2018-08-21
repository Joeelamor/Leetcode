// Question 884 Uncommon Words From Two Sentences

class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] arr = (A + " " + B).split(" ");
        for (String str : arr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        ArrayList<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res.add(entry.getKey());
            }
        }
        return res.toArray(new String[0]);
    }
}