// Problem 557 Reverse Words In A String III

// Write a reverse function by myself
class Solution {
    public String reverseWords(String s) {
        String []str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length; i++) {
            str[i] = reverse(str[i]);
        }
        StringBuilder res = new StringBuilder();
        for(String st: str) {
            res.append(st + " ");
        }
        return res.toString().trim();
    }
    public String reverse(String str) {
        int i = 0, j = str.length() - 1;
        char []c = str.toCharArray();
        while(i < j) {
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
            i++;
            j--;
        }
        return new String(c);
    }
}

// Or just use an existed function
class Solution{    
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) str[i] = new StringBuilder(str[i]).reverse().toString();
        StringBuilder result = new StringBuilder();
        for (String st : str) result.append(st + " ");
        return result.toString().trim();
    } 
}