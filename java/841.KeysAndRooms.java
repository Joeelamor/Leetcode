// Problem 841 Keys And Rooms

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        set.add(0);
        q.offer(0);
        while (!q.isEmpty()) {
            int room = q.poll();
            for (Integer key: rooms.get(room)) {
                if (!set.contains(key)) {
                    set.add(key);
                    q.offer(key);
                }
            }
        }
        return set.size() == rooms.size();
    }
}