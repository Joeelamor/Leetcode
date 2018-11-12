// Question 556 Next Greater Element III

class Solution {
    public int nextGreaterElement(int n) {
        char[] ch = (n + "").toCharArray();
        int i = ch.length - 2;
        while (i >= 0 && ch[i] >= ch[i + 1])
            i--;
        if (i < 0)
            return -1;
        int j = ch.length - 1;
        while (j > i && ch[j] <= ch[i]) {
            j--;
        }
        swap(ch, i, j);
        reverse(ch, i + 1);
        try {
            return Integer.parseInt(new String(ch));
        } catch (Exception e) {
            return -1;
        }
    }    
    void swap(char[] ch, int i, int j) {
        char c = ch[i];
        ch[i] = ch[j];
        ch[j] = c;
    }
    
    void reverse(char[] ch, int i) {
        int end = ch.length - 1;
        while (i < end) {
            swap(ch, i, end);
            i++;
            end--;
        }
    }
}