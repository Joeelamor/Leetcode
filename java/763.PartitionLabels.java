// Problem 763 Partition Labels

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new LinkedList<>();
        int[] index = new int[26];
        for (int i = 0; i < S.length(); i++) {
            index[S.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            int c = S.charAt(i) - 'a';
            if (index[c] != i) {
                if (index[c] > end)
                    end = index[c]; // store the last index of the partition
            } else if (i == end) { // if cur index is the last index of the partition, then record the length
                res.add(end - start + 1);
                start = i + 1;
                end = i + 1;
            }
        }
        return res;
    }
}