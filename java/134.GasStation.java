// Problem 134 Gas Station

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0, tank = 0, total = 0;
        for (int i = 0; i < gas.length; i++) {
            int fuel = gas[i] - cost[i];
            tank += fuel;
            total += fuel;
            if (tank < 0) {
                tank = 0;
                index = i + 1;
            }
        }
        return total >= 0? index : -1;        
    }
}