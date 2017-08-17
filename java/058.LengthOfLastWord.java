// Problem 58 Length of Last Word

/* general method */
public class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0)
            return 0;
        int i = s.length() - 1;
        int len = 0;
        while(i >= 0) {
            if(s.charAt(i) == ' ') {
                i--;
                if(len != 0)
                    return len;
            }
            else {
                len++;
                i--;
            }
        }
        return len; 
    }
}

/* Use trim() method two delete ' ' in head and end. */
public class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0)
            return 0;
        int i = s.trim().length() - 1;
        while(i >= 0) {
            if(s.trim().charAt(i) == ' ')
                break;
            else
                i--;
        }
        return s.trim().length() - i - 1; 
    }
}


/* A brilliant solution. Use trim() method and lastIndexOf() method. */
public class Solution {
	public int lengthOfLastWord(String s) {
    	return s.trim().length()-s.trim().lastIndexOf(" ")-1;
	}
}
