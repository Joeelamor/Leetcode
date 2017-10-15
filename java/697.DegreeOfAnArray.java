// Problem 697 Degree Of An Array

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i))
                map.put(i, 1);
            else
                map.put(i, map.get(i) + 1);
        }
        int max = 1;
        for (int value: map.values()) {
            max = Math.max(max, value);
        }
        List<Integer> l = new ArrayList<>();
        for (int i : map.keySet()) {
            if (map.get(i) == max)
                l.add(i);
        }
        int res = Integer.MAX_VALUE;
        for (int n : l) {
            for (int i = 0, j = nums.length - 1; i <= j;) {
                if (nums[i] == n && nums[j] == n) {
                    res = Math.min(res, j - i + 1);
                    break;
                }
                else if (nums[i] == n)
                    j--;
                else if (nums[j] == n)
                    i++;
                else {
                    i++;
                    j--;
                }
            }
        }
        return res;
    }
}