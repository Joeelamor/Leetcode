// Problem 475 Heaters

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int heater: heaters) set.add(heater);
        int res = 0;
        for (int house: houses) {
            int dis1 = set.ceiling(house) == null? Integer.MAX_VALUE : set.ceiling(house) - house;
            int dis2 = set.floor(house) == null? Integer.MAX_VALUE : house - set.floor(house);
            res = Math.max(res, Math.min(dis1, dis2));
        }
        return res;
    }
}