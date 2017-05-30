// Problem 119 Pascal's Triangle II

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for(int i = 0; i < rowIndex + 1; i++) {
            row.add(1);
            for(int j = i - 1; j > 0; j--) {
                row.set(j,  row.get(j - 1) + row.get(j));
            }
        }
        return row;
    }
}
