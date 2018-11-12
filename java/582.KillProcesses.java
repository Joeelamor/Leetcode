// Question 582 Kill Processes

// Method 1: use hashmap

class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            if (!map.containsKey(ppid.get(i)))
                map.put(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        q.offer(kill);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                res.add(cur);
                if (map.containsKey(cur))
                    for (int j : map.get(cur))
                        q.offer(j);
            }
        }
        return res;
    }
}

// Method 2: Union Find

class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        int max = 0;
        for (int n: pid) {
            max = Math.max(max, n);
        }
        
        int[] parent = new int[max + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        
        for(int i = 0; i < pid.size(); i++) {
            int p = pid.get(i);
            int pp = ppid.get(i);
            if (p == kill) {
                continue;
            }
            int f1 = find(parent, p);
            int f2 = find(parent, pp);
            if (f1 != f2) {
                parent[p] = pp;  
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < parent.length; i++) {
            if (find(parent, i) == kill) {
                result.add(i);   
            }
        }
        return result;
    }
    private int find(int[] parent, int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
}