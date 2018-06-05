// Problem 846 Hand Of Straights

class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i: hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i: map.keySet()) {
            int count = map.get(i);
            if (count == 0) continue;
            for (int j = i; j < i + W; j++) {
                if (map.get(j) == null || map.get(j) < count) return false;
                map.put(j, map.get(j) - count);
            }
        }
        return true;
    }
}