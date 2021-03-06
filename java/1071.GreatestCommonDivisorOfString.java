// Question 1071 Greatest Common Divisor of Strings

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length())
            return gcdOfStrings(str2, str1);
        if (str2.length() == 0)
            return str1;
        if (str1.startsWith(str2)){
            while(str1.startsWith(str2)){
                str1 = str1.substring(str2.length());
            }
            return gcdOfStrings(str2, str1);
        } else {
            return "";
        }
    }
}