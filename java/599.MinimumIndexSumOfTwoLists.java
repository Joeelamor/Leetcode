// Problem 599 Minimum Index Sum Of Two Lists

// Use a subtle technique in an 'if' phase new a list to replace the minSum
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> res = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;
        for(int i = 0; i < list2.length; i++) {
            Integer j = map.get(list2[i]);
            if(j != null && i + j <= minSum) {
                if(i + j < minSum) {
                    res = new ArrayList<>();
                    minSum = i + j;
                }
                res.add(list2[i]);
            }
                
        }
        return res.toArray(new String[res.size()]);
    }
}