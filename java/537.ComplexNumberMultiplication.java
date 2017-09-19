// Problem 537 Complex Number Multiplication

/* (a1 + a2i)(b1 + b2i) = (a1 * b1 - a2 * b2) + (a1 * b2 + b1 * a2) * i */
class Solution {
    public String complexNumberMultiply(String a, String b) {
        String A[] = a.split("\\+");
        String B[] = b.split("\\+");
        int a1 = Integer.parseInt(A[0]);
        int a2 = Integer.parseInt(A[1].replace("i", ""));
        int b1 = Integer.parseInt(B[0]);
        int b2 = Integer.parseInt(B[1].replace("i", ""));
        int part1 = a1 * b1 - a2 * b2;
        int part2 = a1 * b2 + b1 * a2;
        String res = part1 + "" + "+" + part2 + "i";
        return res;
    }
}