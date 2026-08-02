class Solution {
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        boolean[] visitedrightDai=new boolean[2*n-1];
        boolean[] visitedleftDai=new boolean[2*n-1];
        boolean[] visitedcolumn=new boolean[n];
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        
        queens(0,visitedrightDai,visitedleftDai,visitedcolumn,board,n);
        return res;
    }

    private void queens(int row,boolean[] visitedrightDai,boolean[] visitedleftDai,boolean[] visitedcolumn,char[][] board,int n){

        if(row==n){
            List<String> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                String s=new String(board[i]);
                list.add(s);
            }
            res.add(list);
            return;
        }

        for(int col=0;col<n;col++){
            int currentRd=(row-col)+(n-1);
            int currentLd=row+col;

            if(!visitedrightDai[currentRd]&&!visitedleftDai[currentLd]&&!visitedcolumn[col]){
               visitedrightDai[currentRd]=true;
               visitedleftDai[currentLd]=true;
               visitedcolumn[col]=true;
               board[row][col]='Q';
               queens(row+1,visitedrightDai,visitedleftDai,visitedcolumn,board,n);
               visitedrightDai[currentRd]=false;
               visitedleftDai[currentLd]=false;
               visitedcolumn[col]=false;
               board[row][col]='.';
            }

            
        }
    }
}
