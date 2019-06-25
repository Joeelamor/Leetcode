// Question 1086 High Five

class Solution {
    public int[][] highFive(int[][] items) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int[] item: items) {
            if (!map.containsKey(item[0])) {
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                pq.offer(item[1]);
                map.put(item[0], pq);
            } else {
                map.get(item[0]).add(item[1]) ;
                if(map.get(item[0]).size() > 5)
                    map.get(item[0]).poll() ;
            }
        }
        int[][] res = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            res[i][0] = entry.getKey();
            int sum = 0;
            for (int num : entry.getValue()) {
                sum += num;
            }
            res[i][1] = sum / 5;
            i++;
        }
        return res;
    }
}