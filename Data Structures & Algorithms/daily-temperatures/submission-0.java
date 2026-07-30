class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack=new Stack<>();
        int res[]=new int[temperatures.length];
        for(int i=temperatures.length-1;i>=0;i--){
            int temp=temperatures[i];
            if(stack.isEmpty()){
                stack.push(i);
                res[i]=0;
            }else{
              while(!stack.isEmpty()&&temperatures[stack.peek()]<=temperatures[i]){
                stack.pop();
              }
              if(stack.isEmpty()){
                
                res[i]=0;
            }else{
                res[i]=stack.peek()-i;
            }
            stack.push(i);
            }
        }
        return res;
    }
}
