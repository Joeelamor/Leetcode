// Problem 733 Flood Fill

// Use DFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length, n = image[0].length;
        helper(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    private void helper(int[][] image, int i, int j, int newColor, int originalColor) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != originalColor || image[i][j] == newColor)
            return;
        originalColor = image[i][j];
        image[i][j] = newColor;
        helper(image, i + 1, j, newColor, originalColor);
        helper(image, i - 1, j, newColor, originalColor);
        helper(image, i, j + 1, newColor, originalColor);
        helper(image, i, j - 1, newColor, originalColor);
    }
}