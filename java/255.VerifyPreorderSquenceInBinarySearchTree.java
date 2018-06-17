// Problem 255 Verify Preorder Squence In Binary Search Tree

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i : preorder) {
            if (i < low) return false;
            while (!stack.isEmpty() && i > stack.peek()) {
                low = stack.pop();
            }
            stack.push(i);
        }
        return true;
    }
}