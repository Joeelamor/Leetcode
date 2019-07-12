// Question 1041 Robot Bounded In Circle

class Solution {
    public boolean isRobotBounded(String instructions) {
        int dx = 0, dy = 0, dir = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'L') {
                dir = (dir + 3) % 4;
            } else if (instructions.charAt(i) == 'R') {
                dir = (dir + 1) % 4;
            } else {
                dx += dirs[dir][0];
                dy += dirs[dir][1];
            }
        }
        return dx == 0 && dy == 0 || dir > 0;
    }
}