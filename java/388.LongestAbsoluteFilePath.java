// Problem 388 Longest Absolute File Path

class Solution {
    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        String[] strs = input.split("\n");
        int max = 0;
        stack.push(0);
        for (String str : strs) {
            // "\" doesn't count.
            int numOfTabs = str.lastIndexOf("\t") + 1;
            int level = numOfTabs + 1;
            while (level < stack.size()) {
                stack.pop();
            }
            int len = stack.peek() + str.length() - numOfTabs + 1;
            stack.push(len);
            if (str.contains(".")) max = Math.max(max, len - 1);
        }
        return max;
    }
}