// Question 787 Cheapest Flights Within K Stops

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        for (int[] flight : flights) {
            if (!graph.containsKey(flight[0]))
                graph.put(flight[0], new HashMap<>());
            graph.get(flight[0]).put(flight[1], flight[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        pq.offer(new int[]{0, src, K + 1});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int price = cur[0];
            int city = cur[1];
            int stop = cur[2];
            if (city == dst)
                return price;
            if (stop > 0) {
                HashMap<Integer, Integer> map = graph.getOrDefault(city, new HashMap<>());
                for (int a : map.keySet()) {
                    pq.offer(new int[]{price + map.get(a), a, stop - 1});
                }
            }
        }
        return -1;
    }
}