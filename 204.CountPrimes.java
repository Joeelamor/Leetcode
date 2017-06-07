// Problem 204 Count Primes

/* Use Sieve of Eratosthenes algorithm: 
 * To find all the prime numbers less than or equal to a given integer n by Eratosthenes'  * method:
 * 1. Create a list of consecutive integers from 2 through n: (2, 3, 4, ..., n).
 * 2. Initially, let p equal 2, the smallest prime number.
 * 3. Enumerate the multiples of p by counting to n from 2p in increments of p, and mark  *  them in the list (these will be 2p, 3p, 4p, ...; the p itself should not be marked).
 * 4. Find the first number greater than p in the list that is not marked. If there was no 
 * 	such number, stop. Otherwise, let p now equal this new number (which is the next
 *	prime), and repeat from step 3.
 * 5. When the algorithm terminates, the numbers remaining not marked in the list are all 
 * 	the primes below n. */

 public class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean [] isPrime = new boolean[n];
        for(int i = 2; i < n; i++) {
            if(isPrime[i] == false) {
                count++;
                for(int j = 2; i * j < n; j++) {
                    isPrime[i * j] = true;
                }
            }
        }
        return count;
    }
}