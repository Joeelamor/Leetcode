// Problem 859 Buddy Strings

class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            HashSet<Character> set = new HashSet<>();
            for (char c : A.toCharArray()) {
                set.add(c);
            }
            return set.size() < A.length();
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i))
                list.add(i);
        }
        return list.size() == 2 && A.charAt(list.get(0)) == B.charAt(list.get(1)) && A.charAt(list.get(1)) == B.charAt(list.get(0));
    }
}