// Problem 386 Lexicographical Numbers

// If we look at the order we can find out we just keep adding digit from 0 to 9 to every digit and make it a tree.
// Then we visit every node in pre-order. 
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, res);
        }
        return res;
    }
    private void dfs(int cur, int n, List<Integer> res) {
        if (cur > n) return;
        res.add(cur);
        for (int i = 0; i <= 9; i++) {
            if (cur * 10 + i > n) return;
            dfs(cur * 10 + i, n, res);
        }
    }
}


// Method 2:
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int cur = 1;
        for (int i = 1; i <= n; i++) {
            res.add(cur);
            if (cur * 10 <= n) cur *= 10;
            else if (cur % 10 != 9 && cur + 1 <= n) cur++;
            else {
                while ((cur / 10) % 10 == 9) cur /= 10;
                cur = cur / 10 + 1;
            }
        }
        return res;
    }
}