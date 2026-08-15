class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n=gas.length;
        int sumGas=0,sumCost=0;

        for(int i=0;i<n;i++){
            sumGas=gas[i]+sumGas;
            sumCost=sumCost+cost[i];
        }

        if(sumGas<sumCost) return -1;
        int total=0;
        int start=0;
        for(int i=0;i<n;i++){
            total=total+(gas[i]-cost[i]);

            if(total<0){
                total=0;
                start=i+1;
            }

        }
        return start;
        
    }
}
