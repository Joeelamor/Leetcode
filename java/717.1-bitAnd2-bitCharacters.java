// Problem 717 1-bit and 2-bit Characters

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1) {
            return true;
        } 
        if (bits == null || bits.length == 0)
            return false;
        int i = 0;
        if (bits[i] == 0)
            return isOneBitCharacter(Arrays.copyOfRange(bits, i + 1, bits.length));
        if (bits[i] == 1) {
            return isOneBitCharacter(Arrays.copyOfRange(bits, i + 2, bits.length));
        }
        return false;
    }
}