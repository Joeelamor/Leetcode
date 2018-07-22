// Problem 874 Walking Robot Simulation

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        if (commands == null || commands.length == 0) return 0;
        HashSet<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + "," + obstacle[1]);
        }
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0, max = 0, x = 0, y = 0;
        for (int command : commands) {
            if (command == -1) {
                direction = (direction + 1) % 4;
            } else if (command == -2) {
                direction = (direction - 1) % 4;
                if (direction < 0)
                    direction += 4;
            } else {
                for (int i = 0; i < command; i++) {
                    if (set.contains((x + directions[direction][0]) + "," + (y + directions[direction][1])))
                        break;
                    x += directions[direction][0];
                    y += directions[direction][1];
                    max = Math.max(max, x * x + y * y);
                }
            }
        }
        return max;
    }
}