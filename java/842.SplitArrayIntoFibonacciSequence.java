// Problem 842 Split Array Into Fibonacci Sequence

class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        LinkedList<Integer> res = new LinkedList<>();
        helper(S, res, 0);
        return res;
    }
    private boolean helper(String s, List<Integer> list, int index) {
        if (index == s.length() && list.size() >= 3) return true;
        for (int i = index; i < s.length(); i++) {
            if (s.charAt(index) == '0' && i > index) break;
            long num = Long.parseLong(s.substring(index, i + 1));
            if (num > Integer.MAX_VALUE) break;
            int size = list.size();
            if (size >= 2 && num > list.get(size - 1) + list.get(size - 2)) break;
            if (size <= 1 || num == list.get(size - 1) + list.get(size - 2)) {
                list.add((int)num);
                if (helper(s, list, i + 1)) {
                    return true;
                }
                list.remove(list.size() - 1);
            }
        }
        return false;
    }
}