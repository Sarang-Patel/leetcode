# Water Bottles II
class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int total = 0;
        int empty = 0;

        while(numBottles > 0 || empty >= numExchange) {
            while(empty >= numExchange) {
                numBottles += 1;
                empty -= numExchange;
                numExchange += 1;
            }

                total += numBottles;
                empty += numBottles;
                numBottles = 0;
            
        }

        return total;
    }
}