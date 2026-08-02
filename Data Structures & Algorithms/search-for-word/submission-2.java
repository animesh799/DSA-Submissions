class Solution {
    public boolean exist(char[][] board, String word) {
        boolean flag=false;
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                flag=findWord(i,j,new HashSet<>(),m,n,new StringBuilder(),board,word,0);
                if(flag){
                    return true;
                }
            }
        }
        return false;
        
    }


    private boolean findWord(int row,int col,Set<Integer> visited,int m,int n,StringBuilder sb,char[][] board,String word,int curr){
        if(row<0||col<0||row>=m||col>=n){
            return false;
        }

        int idx=(row)*n+col;
        if(!visited.add(idx)){
            return false;
        }


        char ch=board[row][col];

        if(ch!=word.charAt(curr)){
            visited.remove(idx); 
           return false;
        }

        sb.append(ch);
        



        if(sb.length()==word.length()){
            return word.equals(sb.toString());
        }

        boolean flag=false;

            if(!flag){
                flag=flag||findWord(row-1,col,visited,m,n,sb,board,word,curr+1);
            }  


            if(!flag){
                flag=flag||findWord(row+1,col,visited,m,n,sb,board,word,curr+1);
            }  
        

            if(!flag){
                flag=flag||findWord(row,col-1,visited,m,n,sb,board,word,curr+1);
            }  
        

            if(!flag){
                flag=flag||findWord(row,col+1,visited,m,n,sb,board,word,curr+1);;
            }
            
            idx=(row)*n+col;
            sb.deleteCharAt(sb.length()-1);
            visited.remove(idx);  

        return flag;
    
    
}
}



