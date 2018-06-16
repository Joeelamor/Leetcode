// Problem 247 Strobogrammatic Number II

class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> one = Arrays.asList("0", "1", "8"), two = Arrays.asList(""), res = two;
        if (n % 2 == 1) {
            res = one;
        }
        for (int i = (n % 2) + 2; i <= n; i += 2) {
            List<String> list = new ArrayList<>();
            for (String str : res) {
                if (i != n) {
                    list.add("0" + str + "0");
                }
                list.add("1" + str + "1");
                list.add("8" + str + "8");
                list.add("6" + str + "9");
                list.add("9" + str + "6");
            }
            res = list;
        }
        return res;
    }
}