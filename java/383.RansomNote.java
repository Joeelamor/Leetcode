// Problem 383 Ransom Note

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int container[] = new int[26];
        for(int i = 0; i < magazine.length(); i++) 
            container[magazine.charAt(i) - 'a']++;
        for(int i = 0; i < ransomNote.length(); i++) {
            if(--container[ransomNote.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }
}