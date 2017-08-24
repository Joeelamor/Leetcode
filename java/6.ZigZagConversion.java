// Problem 6 ZigZag Conversion

// Use a smart method
class Solution {
    public String convert(String s, int numRows) {
        StringBuilder []sb = new StringBuilder[numRows];
        if(numRows <= 1)
            return s;
        for(int i = 0; i < sb.length; i++) 
            sb[i] = new StringBuilder("");
        int parameter = 1, index = 0;
        for(int i = 0; i < s.length(); i++) {
            sb[index].append(s.charAt(i));
            if(index == 0)
                parameter = 1;
            if(index == numRows - 1)
                parameter = -1;
            index += parameter;
        }
        String res = "";
        for(int i = 0; i < sb.length; i++)
            res += sb[i];
        return res.toString();
    }
}