class Solution {

    public int numIslands(char[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        // Stores the number of separate islands.
        int count = 0;

        // Keeps track of cells that have already been discovered.
        boolean[][] visited = new boolean[row][col];

        /*
         * Traverse every cell in the grid.
         *
         * Whenever we find an unvisited land cell,
         * it means we have found a NEW island.
         */
        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                // Current cell is land and hasn't been visited.
                if (!visited[i][j] && grid[i][j] != '0') {

                    // We found one new island.
                    count++;

                    // Explore the complete island using BFS.
                    bfs(i, j, grid, visited, row, col);
                }
            }
        }

        return count;
    }


    private void bfs(
        int i,
        int j,
        char[][] grid,
        boolean[][] visited,
        int r,
        int c
    ) {

        // Queue is used because we are performing BFS.
        Queue<Pair> queue = new LinkedList<>();

        // Add the starting land cell to the queue.
        Pair pair = new Pair(i, j);
        queue.offer(pair);

        /*
         * IMPORTANT:
         * Mark the cell visited when we ADD it to the queue.
         *
         * This prevents the same cell from being added
         * to the queue multiple times by different neighbours.
         */
        visited[i][j] = true;

        // BFS continues until there are no more cells to explore.
        while (!queue.isEmpty()) {

            // Remove the next cell from the queue.
            Pair pop = queue.poll();

            /*
             * Four possible directions:
             *
             *       UP
             *       (-1,0)
             *
             * LEFT (0,-1)  RIGHT (0,1)
             *
             *       DOWN
             *       (1,0)
             */
            int[] x = {-1, 1, 0, 0};
            int[] y = {0, 0, 1, -1};

            // Check all four neighbours.
            for (int k = 0; k < 4; k++) {

                int newRow = pop.r + x[k];
                int newCol = pop.c + y[k];

                /*
                 * First check whether the neighbour
                 * is inside the grid boundaries.
                 */
                if (newRow >= 0 &&
                    newRow < r &&
                    newCol >= 0 &&
                    newCol < c) {

                    /*
                     * We can visit this neighbour only if:
                     *
                     * 1. It is land ('1')
                     * 2. It has not been visited before
                     */
                    if (grid[newRow][newCol] != '0' &&
                        !visited[newRow][newCol]) {

                        // Add the new land cell to the BFS queue.
                        queue.offer(new Pair(newRow, newCol));

                        /*
                         * Mark it visited IMMEDIATELY when adding
                         * it to the queue.
                         *
                         * This prevents duplicate entries.
                         */
                        visited[newRow][newCol] = true;
                    }
                }
            }
        }
    }


    // Simple class to store row and column of a grid cell.
    class Pair {

        int r;
        int c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}