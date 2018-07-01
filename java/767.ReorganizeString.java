// Problem 767 Reorganize String

class Solution {
    public String reorganizeString(String S) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        int[] frequencies = new int[26];
        for (char c : S.toCharArray()) {
            frequencies[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (frequencies[i] != 0) {
                pq.offer(new int[]{i, frequencies[i]});
            }
        }
        int[] prev = new int[]{-1, 0};
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            // adding prev into pq in next iteration is to avoid repeatly adding same character.
            if (prev[1] > 0) pq.offer(prev);
            sb.append((char)(cur[0] + 'a'));
            cur[1]--;
            prev = cur;
            if (pq.isEmpty() && prev[1] > 0) return "";
        }
        return sb.toString();
    }
}