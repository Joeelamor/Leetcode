// Problem 463 Island Perimeter

public class Solution {
    public int islandPerimeter(int[][] grid) {
        // If we tranverse the matrix, the index will move right and down, so we just need to know how many neighbours on the right and down and count them, the result is islands * 4 - neighbours * 2
        int island = 0, neighbour = 0;        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    island++;
                    if(i < grid.length - 1 && grid[i + 1][j] == 1)
                        neighbour++;
                    if(j < grid[i].length - 1 && grid[i][j + 1] == 1)
                        neighbour++;
                }
            }
        }
        return island * 4 - neighbour * 2; 
    }
}