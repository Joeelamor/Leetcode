// Problem 345 Reverse Vowels of a String

public class Solution {
    public String reverseVowels(String s) {
        char []res = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            char temp = res[i];
            if(vowels.contains(res[i]+"")){
                if(vowels.contains(res[j]+"")) {
                    res[i] = res[j];
                    res[j] = temp;
                    i++;
                    j--;
                }
                else
                    j--;
            }
            else {
                if(vowels.contains(res[j]+"")) {
                    i++;
                }
                else{
                    i++;
                    j--;
                }
                    
            }                   
        }
        return new String(res);
    }
}

// faster think reversely...
public class Solution {
    public String reverseVowels(String s) {
        char []res = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            while(i < j && !vowels.contains(res[i]+"")){
                i++;
            }
               
            while(i < j && !vowels.contains(res[j]+"")) {
                j--;
            }
            char temp = res[i];
            res[i] = res[j];
            res[j] = temp;
            i++;
            j--;
                    
        }                   
        return new String(res);
    }
}