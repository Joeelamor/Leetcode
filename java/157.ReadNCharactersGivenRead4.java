// Problem 157 Read N Characters Given Read4

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int read = 0;
        int hasRead = 0;
        while (true) {
            read = read4(buffer);
            int toRead = Math.min(read, n - hasRead);
            for (int i = 0; i < toRead; i++) {
                buf[hasRead++] = buffer[i];
            }
            if (read < 4) return hasRead;
            if (hasRead == n) return n;
        }
    }
}