// Problem 683 K Empty Slots

/* Method 1: use TreeSet to keep current position, then use TreeSet.lower() and 
 * TreeSet.higher() function to find the day.
 */
class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            int current = flowers[i];
            Integer next = treeSet.higher(current);
            if (next != null && next - current == k + 1) {
                return i + 1;
            }
            Integer pre = treeSet.lower(current);
            if (pre != null && current - pre == k + 1) {
                return i + 1;
            }
            treeSet.add(current);
        }
        return -1;
    }
}

/* Method 2: Use boolean to keep the blooming position, then in each day, traverse left and 
 * right to find if there is a day.
 */
class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        if (k > flowers.length)
            return -1;
        int b = 0;
        boolean[] boom = new boolean[flowers.length+1];
        for (int f : flowers) {
            b++;
            boom[f] = true;
            int i;
            for (i = 1; f + i <= flowers.length && !boom[f + i]; i++);
            if (f + i <= flowers.length && i - 1 == k)
                return b;
            for (i = -1; f + i > 0 && !boom[f + i]; i--);
            if (f + i > 0 && 0 - i - 1 == k)
                return b;
        }
        return -1;
    }
}