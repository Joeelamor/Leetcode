// Problem 492 Construct the Rectangle

// Just start from sqrt(area) which is the fast find width or length.
class Solution {
    public int[] constructRectangle(int area) {
        int width = (int)Math.sqrt(area);
        while(area % width != 0) {
            width--;
        }
        return new int[] {area / width, width};
    }
}