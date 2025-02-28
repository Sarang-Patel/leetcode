# Number of 1 Bits
class Solution {
    public int hammingWeight(int n) {
        int s = 0;

        while(n != 0) {
            if ((n & 1) == 1)
            s +=1;

            n = n >> 1;
        }

        return s;
    }
}