class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Character>> rowmap=new HashMap<>();
        Map<Integer,Set<Character>> colmap=new HashMap<>();
        Map<String,Set<Character>> blockmap=new HashMap<>();
        
        for(int i=0;i<9;i++){
           rowmap.put(i,new HashSet<Character>());
           colmap.put(i,new HashSet<Character>());
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                String key=i+"#"+j;
              blockmap.put(key,new HashSet<Character>());
            }
        }



        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                char ch=board[row][col];
                if(ch!='.'){
                    Set<Character> rowSet=rowmap.get(row);
                    Set<Character> colSet=colmap.get(col);
                    String blockKey=(row/3)+"#"+(col/3);
                    Set<Character> blockSet=blockmap.get(blockKey);

                    if(rowSet.contains(ch)||colSet.contains(ch)||blockSet.contains(ch)){
                        return false;
                    }else{
                        rowSet.add(ch);
                        colSet.add(ch);
                        blockSet.add(ch);
                    }
                }
            }
        }
        return true;
        
    }
}
