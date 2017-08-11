// Problem 389 Find the Difference

// use hashMap
public class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(!hashMap.containsKey(s.charAt(i)))
                hashMap.put(s.charAt(i), 1);
            else
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
        }
        char ta = 'a';
        for(int i = 0; i < t.length(); i++) {
            if(hashMap.containsKey(t.charAt(i))){
                if(hashMap.get(t.charAt(i)) <= 0) {
                    ta = t.charAt(i);
                    break;
                }
                else
                    hashMap.put(t.charAt(i), hashMap.get(t.charAt(i)) - 1);
            }
            else {
                ta =  t.charAt(i);
                break;
            }                
        }    
        return ta;
    }
}

// use char => int
public class Solution {
    public char findTheDifference(String s, String t) {
        int charCode = (int)t.charAt(s.length());
        for(int i = 0; i < s.length(); i++) {
            charCode -= (int)s.charAt(i);
            charCode += (int)t.charAt(i);
        }
        return (char)charCode;
    }
}

// use array instead of hashMap
public class Solution {
    public char findTheDifference(String s, String t) {
        int alpha[] = new int[26];
        for(int i = 0; i < 26; i++) 
            alpha[i] = 0;
        for(char c: s.toCharArray()) 
            alpha[c - 'a']++;
        for(char c: t.toCharArray()) {
            if(--alpha[c - 'a'] < 0)
                return c;
        }
        return 0;
    }
}

// use XOR
public class Solution {
    public char findTheDifference(String s, String t) {
        char c = t.charAt(s.length());
        for(int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }
}
