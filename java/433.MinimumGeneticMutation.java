// Question 433 Minimum Genetic Mutation

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        char[] chars = {'A', 'C', 'G', 'T'};
        Set<String> bankSet = new HashSet<>();
        int level = 0;
        queue.offer(start);
        for (String b : bank) {
            bankSet.add(b);
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                String currString = queue.poll();
                if (currString.equals(end)) return level;
                for (int i = 0; i < currString.length(); i++) {
                    for (char ch: chars) {
                        char[] currChars = currString.toCharArray();
                        currChars[i] = ch;
                        String modString = new String(currChars);
                        if (bankSet.contains(modString)) {
                            queue.add(modString);
                            bankSet.remove(modString);
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}