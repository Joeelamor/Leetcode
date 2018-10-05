// Question 158 Read N Characters Given Read4 II - Call multiple times

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    
    int preIndex = 0;
    int preSize = 0;
    char[] tmp = new char[4];
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        while (count < n) {
            if (preIndex < preSize) {
                buf[count++] = tmp[preIndex++];
            } else {
                preSize = read4(tmp);
                preIndex = 0;
                if (preSize == 0)
                    break;
            }
        }
        return count;
    }
}