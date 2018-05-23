// Problem 760 Find Anagram Mappings

class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        int[] res = new int[A.length];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            map.computeIfAbsent(B[i], k -> new ArrayList<Integer>()).add(i);
        }
        for (int i = 0; i < A.length; i++) {
            res[i] = map.get(A[i]).remove(map.get(A[i]).size() - 1);
        }
        return res;
    }
}

