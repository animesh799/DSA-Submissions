class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int row=heights.length;
        int col=heights[0].length;

        int grid[][]=new int[row][col];

        List<Pair> pecific=new ArrayList<>();

        for(int i=0;i<col;i++){
            pecific.add(new Pair(0,i));
        }

        for(int i=0;i<row;i++){
            pecific.add(new Pair(i,0));
        }

        bfs(heights,grid,pecific);

        List<Pair> atlantic=new ArrayList<>();

        for(int i=0;i<col;i++){
            atlantic.add(new Pair(row-1,i));
        }

        for(int i=0;i<row;i++){
            atlantic.add(new Pair(i,col-1));
        }

        bfs(heights,grid,atlantic);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    List<Integer> list=new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }

        return res;


        
    }

  private void bfs(int[][] heights, int[][] grid, List<Pair> sources) {

    int row = heights.length;
    int col = heights[0].length;

    boolean[][] visited = new boolean[row][col];

    Queue<Pair> queue = new LinkedList<>();

    // Add all ocean-border cells as BFS sources.
    for (int i = 0; i < sources.size(); i++) {

        Pair source = sources.get(i);

        /*
         * IMPORTANT:
         * Corner cells can appear twice in sources.
         *
         * Example:
         * (0,0) belongs to both top and left borders.
         */
        if (!visited[source.x][source.y]) {

            queue.offer(source);

            visited[source.x][source.y] = true;

            // Mark that this cell can reach this ocean.
            grid[source.x][source.y]++;
        }
    }


    // Multi-source BFS
    while (!queue.isEmpty()) {

        Pair poll = queue.poll();

        int[] x = {0, 0, 1, -1};
        int[] y = {1, -1, 0, 0};

        for (int k = 0; k < 4; k++) {

            int newRow = poll.x + x[k];
            int newCol = poll.y + y[k];

            // Check boundaries.
            if (newRow >= 0 &&
                newRow < row &&
                newCol >= 0 &&
                newCol < col) {

                /*
                 * REVERSE FLOW:
                 *
                 * We start from ocean and move towards cells
                 * whose height is >= current cell.
                 *
                 * Why?
                 *
                 * Original water flow:
                 *
                 * higher/equal → lower/equal
                 *
                 * Reverse BFS:
                 *
                 * lower/equal → higher/equal
                 */
                if (!visited[newRow][newCol] &&
                    heights[newRow][newCol] >= heights[poll.x][poll.y]) {

                    visited[newRow][newCol] = true;

                    // This cell can reach this ocean.
                    grid[newRow][newCol]++;

                    queue.offer(new Pair(newRow, newCol));
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
