// Problem 640 Solve the Equation

/* Example:
 * x +5 -2x = 6 -3x;
 * leftPart : tokens= { x, +5, -2x}; coefficient for x = 1-2 =-1; constant = 5;
 * rightPart: tokens= {6, -3x}; coefficient for x = -3; constant = 6;
 * final result = (6-5)/ (-1 - (-3))
 */
class Solution {
    public String solveEquation(String equation) {
        String []parts = equation.split("=");
        int []left = evaluate(parts[0]);
        int []right = evaluate(parts[1]);
        if(left[0] == right[0] && left[1] == right[1])
            return "Infinite solutions";
        else if(left[0] == right[0])
            return "No solution";
        else
            return "x=" + (right[1] - left[1]) / (left[0] - right[0]);
        
    }
    public int[] evaluate(String str) {
    	// ()for match group; ?= for match and include in res; [+-] means + or -;
        String []token = str.split("(?=[+-])");
        // coefficient for x;  coefficient for constant
        int []res = new int[2];
        for(String s: token) {
            if(s.equals("+x") || s.equals("x")) // x means 1x
                res[0]++;
            else if(s.equals("-x"))
                res[0]--;
            else if(s.contains("x")) 
                res[0] += Integer.parseInt(s.substring(0, s.length() - 1));
            else
                res[1] += Integer.parseInt(s);
        }
        return res;
    }
}