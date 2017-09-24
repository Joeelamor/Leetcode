// Problem 682 Baseball Game

class Solution {
    public int calPoints(String[] ops) {
        int sum = 0;
        int []arr = new int[ops.length];
        int index = 0;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("C")) {
                arr[index - 1] = 0;
                index--;
            }
            else if (ops[i].equals("D")) {
                arr[index] = arr[index - 1] * 2;
                index++;
            }
            else if (ops[i].equals("+")) {
                arr[index] = arr[index - 1] + arr[index - 2];
                index++;
            } else {
                arr[index] = Integer.parseInt(ops[i]);
                index++;
            }
        }
        for (int i: arr) {
            sum += i;
        }
        return sum;
    }
}