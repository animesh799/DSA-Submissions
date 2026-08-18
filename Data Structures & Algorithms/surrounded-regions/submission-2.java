class Solution {
    public void solve(char[][] board) {

        int n=board.length;
        int m=board[0].length;
        boolean visited[][]=new boolean[n][m];
        

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char ch=board[i][j];
                if(ch=='O'&&!visited[i][j]){
                        //                     if(i==3&&j==1){
                        //     System.out.println("Print :"+ch);
                        // }

                    if(i==0||j==0||i==n-1||j==m-1){
                        dfs(i,j,board,visited,n,m,false);
                    }

                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char ch=board[i][j];
                if(ch=='O'){
                    board[i][j]='X';
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char ch=board[i][j];
                if(ch=='#'){
                    board[i][j]='O';
                }
            }
        }
        
    }

    private void dfs(int r,int c,char[][] board,boolean visited[][],int n,int m,boolean mark){
        board[r][c]='#';
         
        int x[]=new int[]{0,0,-1,1};
        int y[]=new int[]{-1,1,0,0};

        for(int i=0;i<4;i++){
            int newRow=r+x[i];
            int newCol=c+y[i];

            if(newRow>=0&&newRow<n&&newCol>=0&&newCol<m){
                if(!visited[newRow][newCol]&&board[newRow][newCol]=='O'){
                    visited[newRow][newCol]=true;
                    dfs(newRow,newCol,board,visited,n,m,mark);
                }
            }
        }



    }
}
