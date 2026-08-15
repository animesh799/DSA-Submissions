class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;

        // Calculate the total amount of gas available
        // and the total cost required for the complete circuit.
        int sumGas = 0;
        int sumCost = 0;

        for (int i = 0; i < n; i++) {

            sumGas = sumGas + gas[i];
            sumCost = sumCost + cost[i];
        }

        /*
         * If total gas available is less than total cost,
         * it is impossible to complete the circuit from
         * any starting station.
         */
        if (sumGas < sumCost) {
            return -1;
        }

        /*
         * 'total' represents the amount of gas left in the tank
         * while travelling from the current 'start'.
         */
        int total = 0;

        // Candidate starting station.
        int start = 0;

        for (int i = 0; i < n; i++) {

            /*
             * Gas gained/lost at the current station:
             *
             * gas[i]  -> gas we receive
             * cost[i] -> gas required to reach next station
             */
            total = total + (gas[i] - cost[i]);

            /*
             * If total becomes negative, it means:
             *
             * We cannot reach station i+1 from 'start'.
             *
             * Therefore, none of the stations between
             * 'start' and 'i' can be a valid starting point.
             *
             * So we skip all of them and start from i+1.
             */
            if (total < 0) {

                total = 0;
                start = i + 1;
            }
        }

        /*
         * We already checked that total gas >= total cost.
         * Therefore, the 'start' found above is guaranteed
         * to complete the circuit.
         */
        return start;
    }
}