class Solution {
    public int numIslands(char[][] grid) {

        int row=grid.length;
        int col=grid[0].length;
        int count=0;

        boolean[][] visited=new boolean[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){

                if(!visited[i][j]&&grid[i][j]!='0'){
                    count++;

                    bfs(i,j,grid,visited,row,col);
                }

            }
        }

        return count;
        
    }


    private void bfs(int i,int j,char[][] grid,boolean[][] visited,int r,int c){

        Queue<Pair> queue=new LinkedList<>();
        Pair pair=new Pair(i,j);

        queue.offer(pair);
        visited[i][j]=true;

        while(!queue.isEmpty()){
            Pair pop=queue.poll();
            

            int x[]=new int[]{-1,1,0,0};
            int y[]=new int[]{0,0,1,-1};

            for(int k=0;k<4;k++){

                if((pop.r+x[k])>=0 && (pop.r+x[k]<r) && (pop.c+y[k]>=0)&&(pop.c+y[k]<c)){
                    int newRow=pop.r+x[k];
                    int newCol=pop.c+y[k];
                    if(grid[newRow][newCol]!='0'&& !visited[newRow][newCol]){
                        queue.offer(new Pair(newRow,newCol));
                        visited[newRow][newCol]=true;
                    }
                }

            }

        }



    }

    class Pair{
        int r,c;
        public Pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
}
