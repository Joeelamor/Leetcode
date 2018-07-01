// Problem 621 Task Scheduler

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for (int i : frequencies) {
            if (i != 0) {
                pq.offer(i);
            }
        }
        int time = 0, timeRemaining = tasks.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (timeRemaining > 0) {
            Integer prev = map.get(time);
            if (prev != null) pq.offer(prev);
            Integer cur = pq.poll();
            if (cur != null) timeRemaining--;
            if (cur != null && --cur > 0) map.put(time + n + 1, cur);
            time++;
        }
        return time;
    }
}