// Problem 5 Longest Palindrome Substring

/* Time limit exceeded
 * this answer using old method forces to solve problem, but time limit exceeds. */

public class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        
        if(length < 2)
        	return s;

        int max = 1;
        int head = 0;
        int tail = 1;
        int curLen = 0;
        for(int i = 0; i < length; i++) {
            if (max > length - i)
                break;
        	for(int j = length - 1; j > i; j--) {
        		boolean test = isSymmetric(s, i, j);
        		if(test == true) {
        			curLen = j - i + 1;
        			break;
        		}
        	}
        	if(max < curLen){
        		max = curLen;
        	    head = i;
        	    tail = head + max;
        	}
        }
        return s.substring(head, tail);
    }

    public boolean isSymmetric(String s, int i, int j) {
    	if(i == j)
    		return true;
    	if(j == i + 1)
    	    return (s.charAt(i) == s.charAt(j));
    	if(s.charAt(i) == s.charAt(j)) {
    	    i++;
    	    j--;
    		return isSymmetric(s, i, j);
    	}
    	else
    		return false;
    }
}



/*right answer*/

//this answer firstly find the replicate character in string and then move left 
//from beginner and move right from ender to find the longest palindrome substring

public class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        if(length < 2)
        	return s;

        int max = 1;
        int head = 0;
        int curLen = 0;
        for(int i = 0; i < length;) {
            if(length - i <= max/2)
                break;
            int j = i;
            int k = i;
            while(k < length && s.charAt(k) == s.charAt(i))
                k++;
        	i = k;
        	while(k < length + 1 && j >= 0 && s.charAt(k - 1) == s.charAt(j)) {
        	    ++k;
        	    --j;
        	}
        	
        	curLen = k - j - 2;
        	if(max < curLen){
        		max = curLen;
        	    head = j + 1;
        	}
        }
        return s.substring(head, head + max);
    }
}