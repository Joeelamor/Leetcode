// Problem 460 Queue Reconstruction By Height

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        /** input [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
         *  after sort [[7, 0], [7, 1], [6, 1], [5, 0], [5, 2], [4, 4]]
         *  then insert to list.
         */
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> res = new LinkedList<>();
        for (int[] i : people) {
            res.add(i[1], i);
        }
        return res.toArray(new int[res.size()][]);
    }
}