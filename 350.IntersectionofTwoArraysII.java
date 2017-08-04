// Problem 350  Intersection of Two Arrays II

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++) {
            if(hashMap.containsKey(nums1[i])) {
                hashMap.put(nums1[i], hashMap.get(nums1[i]) + 1);
            }
            else
                hashMap.put(nums1[i], 1);
        }
        for(int i = 0; i < nums2.length; i++) {
            if(hashMap.containsKey(nums2[i]) && hashMap.get(nums2[i]) > 0) {
                res.add(nums2[i]);
                hashMap.put(nums2[i], hashMap.get(nums2[i]) - 1);
            }
        }
        int [] result = new int[res.size()];
        int i = 0;
        for (Integer num : res) {
            result[i++] = num;
        }
        return result;
    }
}