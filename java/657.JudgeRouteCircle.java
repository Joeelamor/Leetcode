// Problem 657 Judge Route Circle

class Solution {
    public boolean judgeCircle(String moves) {
        if (moves.length() == 0) return true;
        if (moves.length() % 2 != 0) return false;
        int x = 0, y = 0;
        for (char c: moves.toCharArray()) {
            if (c == 'U') x += 1;
            if (c == 'D') x += -1;
            if (c == 'L') y += 1;
            if (c == 'R') y += -1;
        }
        return x == 0 && y == 0;
    }
}