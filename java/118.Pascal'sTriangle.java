// Problem 118 Pascal's Triangle

// Straight forward
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < i + 1; j++) {
                if(j == 0 || j == i) 
                    row.add(1);
                else
                    row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            result.add(row);
        }
        return result;
    }
}

// New method
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            row.add(1); // Add 1 at the end.
            for(int j = row.size() - 2; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1)); // From right to left.
            }
            res.add(new ArrayList<Integer>(row));
        }
        return res;
    }
}

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            row.add(0, 1); // Set the first number 1.
            for(int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1)); // From left to right.
            }
            res.add(new ArrayList<Integer>(row));
        }
        return res;
    }
}