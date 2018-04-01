// Problem 811 Subdomain Visit Count

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String s: cpdomains) {
            String[] str = s.split(" ");
            int n = Integer.parseInt(str[0]);
            map.put(str[1], map.getOrDefault(str[1], 0) + n);
            for (int i = 0; i < str[1].length(); i++) {
                if (str[1].charAt(i) == '.') {
                    map.put(str[1].substring(i + 1, str[1].length()), map.getOrDefault(str[1].substring(i + 1, str[1].length()), 0) + n);
                }
            }
        }
        for (String str: map.keySet()) {
            list.add(map.get(str) + " " + str);
        }
        return list;
    }
}