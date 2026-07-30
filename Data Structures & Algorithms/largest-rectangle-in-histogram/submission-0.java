class Solution {
    public int largestRectangleArea(int[] heights) {
        int l=heights.length;

        //pair (index,height)


        //stack
        Stack<Pair> stack=new Stack<>();


        //max calculation when poping happens otherwise we can go wih the element and it can survive onl
        //when less element is encontered then only the prev element have to be calculated
 
        int area=0;

        for(int i=0;i<l;i++){

            int addIndex=i;//needed for backward extension of current element

            while(!stack.isEmpty()&&stack.peek().height>heights[i]){
                Pair pair=stack.pop();
                area=Math.max(area,(i-pair.index)*pair.height);
                addIndex=pair.index;
            }
            stack.push(new Pair(addIndex,heights[i]));
        }

        while(!stack.isEmpty()){
                Pair pair=stack.pop();
                area=Math.max(area,(l-pair.index)*pair.height);  //
        }


        return area;
    }

    class Pair{
        int height,index;
        public Pair(int index,int height){
          this.height=height;
          this.index=index;
        }
    }
}
