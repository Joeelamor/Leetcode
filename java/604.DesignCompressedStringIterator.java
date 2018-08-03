// Question 604 Design Compressed String Iterator

class StringIterator {
    Queue<int[]> q = new LinkedList<>();
    public StringIterator(String compressedString) {
        int i = 0, n = compressedString.length();
        while (i < n) {
            int j = i + 1;
            while (j < n && compressedString.charAt(j) - 'A' < 0) j++;
            q.add(new int[]{compressedString.charAt(i) - 'A', Integer.parseInt(compressedString.substring(i + 1, j))});
            i = j;
        }
    }
    
    public char next() {
        if (q.isEmpty()) return ' ';
        int[] cur = q.peek();
        if (cur[1] == 1) q.poll();
        else cur[1] -= 1;
        return (char)(cur[0] + 'A');
    }
    
    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */