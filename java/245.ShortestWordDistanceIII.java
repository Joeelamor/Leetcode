// Problem 245 Shortest Word Distance III

class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1))
                index1 = i;
            if (index1 != -1 && index2 != -1 && index1 != index2)
                min = Math.min(min, Math.abs(index1 - index2));
            if (words[i].equals(word2))
                index2 = i;
            if (index1 != -1 && index2 != -1 && index1 != index2)
                min = Math.min(min, Math.abs(index1 - index2));
        }
        return min;
    }
}
