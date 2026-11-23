class Solution {
    public int numIslands(char[][] grid) {

        int row=grid.length;
        int col=grid[0].length;

        boolean visited[][]=new boolean[row][col];
        int count=0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                char cell=grid[i][j];
                if(cell=='1'&&!visited[i][j]){
                    count++;
                    visited[i][j]=true;
                    dfs(grid,visited,i,j,row,col);
                }
                // print2DArray(visited);
                // System.out.println();
            }
        }

        return count;
        
    }

    private void dfs(char[][] grid,boolean[][] visited,int r,int c,int m,int n){

        int x[]=new int[]{-1,1,0,0};
        int y[]=new int[]{0,0,-1,1};

        for(int i=0;i<4;i++){
            int newRow=r+x[i];
            int newCol=c+y[i];
         //   System.out.println("X:"+newRow+" Y:"+newCol);
            if(newRow>=0&&newCol>=0&&newRow<m&&newCol<n&&!visited[newRow][newCol]&&grid[newRow][newCol]=='1'){
            //    System.out.println("X:"+newRow+" Y:"+newCol+" enter");
                visited[newRow][newCol]=true;
                dfs(grid,visited,newRow,newCol,m,n);
            }
        }

        return;





    }

    public void print2DArray(boolean[][] arr) {

    for (int i = 0; i < arr.length; i++) {

        for (int j = 0; j < arr[i].length; j++) {
            System.out.print(arr[i][j] + " ");
        }

        System.out.println();
    }
}
}
