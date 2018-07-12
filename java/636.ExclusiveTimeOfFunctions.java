// Problem 636 Exclusive Time Of Functions

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Deque<int[]> stack = new ArrayDeque<>();

        for(String log : logs) {
            String[] s = log.split(":");
            int idx = Integer.valueOf(s[0]);
            int t = Integer.valueOf(s[2]);

            if(s[1].equals("start")) {
                stack.push(new int[]{idx, t});
            } else {
                int v = t - stack.pop()[1] + 1;
                res[idx] += v;
                if(!stack.isEmpty()) res[stack.peek()[0]] -= v;
            }
        }
        return res;
    }
}