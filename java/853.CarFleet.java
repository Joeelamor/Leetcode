// Problem 853 Car Fleet

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = position.length;
        for(int i = 0; i < n; i++){
            map.put(target - position[i], speed[i]);
        }
        int count = 0;
        double r = -1.0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int d = entry.getKey();
            int s = entry.getValue();
            double t = 1.0 * d / s; 
            if(t > r){
                count++;
                r = t;
            }
        }
        return count;
    }
}