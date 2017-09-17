// Problem 241 Different Ways to Add Parentheses

class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '-' || c == '+' || c == '*') {
                String a = input.substring(0, i);
                String b = input.substring(i + 1);
                List<Integer> al = diffWaysToCompute(a);
                List<Integer> bl = diffWaysToCompute(b);
                for(int n: al) {
                    for(int m: bl) {
                        if(c == '-')
                            list.add(n - m);
                        if(c == '+') 
                            list.add(n + m);
                        if(c == '*')
                            list.add(n * m);
                    }
                }
            }
        }
        if(list.size() == 0)
            list.add(Integer.valueOf(input));
        return list;
    }
}