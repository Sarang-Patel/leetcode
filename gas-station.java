# Gas Station
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];

        for (int i = 0; i < gas.length; i++) {
            diff[i] = gas[i] - cost[i];
        }

        int start = 0;
        int total = 0;
        int tank = 0;

        for(int i = 0; i < gas.length; i++) {
            tank += diff[i];
            total += diff[i];

            if(tank < 0) {
                tank = 0;
                start = i + 1;
            }
        }

        if(total < 0) return -1;

        return start;
    }
}