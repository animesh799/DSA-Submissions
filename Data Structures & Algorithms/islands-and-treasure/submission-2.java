class Solution {
    public void islandsAndTreasure(int[][] grid) {

        int row=grid.length;
        int col=grid[0].length;


                    bfs(grid,row,col);

        
    }

    private void bfs(int[][] grid,int rowLim,int colLim){




        boolean visited[][]=new boolean[rowLim][colLim];


        Queue<Pair> queue=new LinkedList<>();



        for(int i=0;i<rowLim;i++){
            for(int j=0;j<colLim;j++){
                if(grid[i][j]==0){
                    queue.offer(new Pair(i,j));
                    visited[i][j]=true;
                }
            }
        }


    //   queue.offer(new Pair(row,col));
        queue.offer(null);
    //    visited[row][col]=true;
        int cost=1;
        while(!queue.isEmpty()){
            Pair poll=queue.poll();

                if(poll==null){
                    cost++;
                                if (!queue.isEmpty()) {
                queue.offer(null);
            }

            continue;
                }
                
                int x[]=new int[]{0,0,1,-1};
                int y[]=new int[]{-1,1,0,0};

        for(int k=0;k<4;k++){
            int newRow=x[k]+poll.x;
            int newCol=y[k]+poll.y;

            if(newRow>=0&&newRow<rowLim&&newCol>=0&&newCol<colLim){
                if(grid[newRow][newCol]!=-1&&!visited[newRow][newCol]){
                     //       System.out.println("enter");
                    grid[newRow][newCol]=Math.min(grid[newRow][newCol],cost);
                    visited[newRow][newCol]=true;
                    queue.offer(new Pair(newRow,newCol));
                }
            }


        }
        
        

        }
    }

    


    class Pair{
        int x,y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;

        }
    }
}

