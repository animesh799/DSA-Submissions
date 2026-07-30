class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        List<Pair> list=new ArrayList<>();

        for(int i=0;i<position.length;i++){
            double time=((target-position[i])*1d)/(speed[i]);
            Pair pair=new Pair(time,position[i]);
            list.add(pair);
        }

        list.sort((a,b)->a.distance-b.distance);

        Stack<Pair> stack=new Stack<>();

        for(int i=0;i<position.length;i++){
            stack.push(list.get(i));
        }
        int count=0;
        while(!stack.isEmpty()){
            Pair pop=stack.pop();
            count++;
            while(!stack.isEmpty()&&stack.peek().time<=pop.time){
               stack.pop();
            }
           
        }

        return count;
    }
}

class Pair{
    double time;
    int distance;
    public Pair(double time,int distance){
      this.time=time;
      this.distance=distance;
    }
}
