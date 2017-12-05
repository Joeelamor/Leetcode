import org.junit.Test;

import static org.junit.Assert.*;

public class DiagonalSumTest {

    @Test
    public void findDiagonalSum() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        DiagonalSum diagonalSum = new DiagonalSum();
        int[] expected = {9, 15, 18, 21, 11, 4};
        assertArrayEquals(expected, diagonalSum.findDiagonalSum(matrix));
    }

    @Test
    public void findDiagonalSum1() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        DiagonalSum diagonalSum = new DiagonalSum();
        int[] expected = {9, 15, 18, 21, 11, 4};
        assertArrayEquals(expected, diagonalSum.findDiagonalSum1(matrix));
    }
}