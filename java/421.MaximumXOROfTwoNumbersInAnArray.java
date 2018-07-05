// Problem 421 Maximum XOR Of Two Numbers In An Array

class Solution {
    class TrieNode {
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[2];
        }
    }
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        TrieNode root = new TrieNode();
        // build trie
        for (int num : nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int curBit = (num >>> i) & 1;
                if (node.children[curBit] == null)
                    node.children[curBit] = new TrieNode();
                node = node.children[curBit];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            TrieNode node = root;
            int curSum = 0;
            for (int i = 31; i >= 0; i--) {
                int curBit = (num >>> i) & 1;
                if (node.children[curBit ^ 1] == null) { // null means no opposite node on same level.
                    node = node.children[curBit];
                } else {
                    curSum += (1 << i);
                    node = node.children[curBit ^ 1];
                }
            }
            max = Math.max(max, curSum);
        }
        return max;
    }
}