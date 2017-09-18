// Problem 451 Sort Characters By Frequency

/* 1. Build a map of characters to the number of times it occurs in the string
 * 2. Create an array where the index of the array represents how many times that character 
 * occurred in the String
 * 3. Iterate from the end of the array to the beginning, and at each index, append each 
 * character to the return string that number of times.
 */

class Solution {
    public String frequencySort(String s) {
        if(s == null)
            return null;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            max = Math.max(max, map.get(c));
        }
        List<Character> [] array = buildArray(map, max);
        return buildString(array);
    }
    public List<Character>[] buildArray(Map<Character, Integer> map, int max) {
        List<Character> [] array = new List[max + 1];
        for(char c: map.keySet()) {
            int count = map.get(c);
            if(array[count] == null) {
                array[count] = new ArrayList();
            }
            array[count].add(c);
        }
        return array;
    }
    public String buildString(List<Character>[] array) {
        StringBuilder sb = new StringBuilder();
        for(int i = array.length - 1; i > 0; i--) {
            List<Character> list = array[i];
            if(list != null) {
                for(char c: list) {
                    for(int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}