class Solution {
    public int orangesRotting(int[][] grid) {

        int row=grid.length;
        int col=grid[0].length;

        boolean visited[][]=new boolean[row][col];

        Queue<Pair> queue=new LinkedList<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    queue.offer(new Pair(i,j));
                }
            }
        }

        int x[]=new int[]{1,-1,0,0};
        int y[]=new int[]{0,0,1,-1};


        int time=0;
        while(!queue.isEmpty()){
            int size=queue.size();

            time++;
            for(int i=1;i<=size;i++){
                Pair poll=queue.poll();

                for(int k=0;k<4;k++){
                    int newRow=poll.x+x[k];
                    int newCol=poll.y+y[k];

                    if(newRow>=0&&newRow<row&&newCol>=0&&newCol<col){
                        if(!visited[newRow][newCol]&&grid[newRow][newCol]==1){
                            grid[newRow][newCol]=2;
                            queue.offer(new Pair(newRow,newCol));
                        }
                    }

                }
            }
            
        }



        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }

        return time==0?0:time-1;
        
    }

    class Pair{
        int x,y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}
