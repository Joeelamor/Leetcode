// Problem 551 Student Attendance Record I

class Solution {
    public boolean checkRecord(String s) {
        char []c = new char[1];
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'A') {
                c[0]++;
                if(c[0] > 1)
                    return false;
            }
            else if(s.charAt(i) == 'L' && i < s.length() - 2) {
                if(s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L')
                    return false;
            }
        }
        return true;
    }
}