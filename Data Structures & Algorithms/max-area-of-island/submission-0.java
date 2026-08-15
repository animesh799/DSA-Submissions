class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int row=grid.length;
        int col=grid[0].length;

        boolean visited[][]=new boolean[row][col];

        int area=0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!visited[i][j]&&grid[i][j]!=0){
                  area=Math.max(area,bfs(i,j,grid,visited,row,col));
                }
            }
        }

        return area;
        
    }

    private int bfs(int i ,int j,int[][] grid,boolean visited[][],int row,int col){
        int area=0;
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(i,j));
        visited[i][j]=true;
        area++;

        while(!queue.isEmpty()){
            Pair pop=queue.poll();

            int x[]=new int[]{0,0,1,-1};
            int y[]=new int[]{1,-1,0,0};

            for(int k=0;k<4;k++){
                int newRow=pop.x+x[k];
                int newCol=pop.y+y[k];

                if(newRow>=0&&newRow<row&&newCol>=0&&newCol<col&&!visited[newRow][newCol]){

                    if(grid[newRow][newCol]!=0){
                        queue.offer(new Pair(newRow,newCol));

                        visited[newRow][newCol]=true;
                        area++;

                    }

                }
            }
            
          

        }
        System.out.println("Area :"+area);
        return area;

    }


    class Pair{
        int x,y;

        public Pair(int row,int col){
            x=row;
            y=col;
        }
    }
}
