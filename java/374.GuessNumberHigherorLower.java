// Problem 374 Guess Number Higher or Lower

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int head = 1, tail = n;
        while(head < tail) {
        	// Use head + (tail-head)/2 not (head + tail) / 2 to avoid exceed int bound.
            int mid = head + (tail-head)/2;
            if(guess(mid) == 0)
                return mid;
            else if(guess(mid) == 1)
                head = mid + 1;
            else
                tail = mid - 1;
        }
        return head;
    }
}