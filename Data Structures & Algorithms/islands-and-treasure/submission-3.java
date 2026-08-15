class Solution {

    public void islandsAndTreasure(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        // Queue will contain ALL treasure cells initially.
        // This is called Multi-Source BFS.
        Queue<Pair> queue = new LinkedList<>();

        /*
         * Put every treasure (0) into the queue.
         *
         * All treasures have distance = 0.
         */
        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                if (grid[i][j] == 0) {
                    queue.offer(new Pair(i, j));
                }
            }
        }

        // Four possible directions:
        // UP, DOWN, LEFT, RIGHT
        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, -1, 1};


        /*
         * Start Multi-Source BFS.
         */
        while (!queue.isEmpty()) {

            /*
             * Number of nodes present in the CURRENT level.
             *
             * Every node in this level is at the same distance
             * from its nearest treasure.
             */
            int size = queue.size();

            /*
             * Process only the nodes belonging to this level.
             */
            for (int i = 0; i < size; i++) {

                // Take the current cell from the queue.
                Pair current = queue.poll();

                // Check all 4 neighbours.
                for (int k = 0; k < 4; k++) {

                    int newRow = current.x + x[k];
                    int newCol = current.y + y[k];

                    /*
                     * Check if the neighbour is inside
                     * the grid.
                     */
                    if (newRow >= 0 &&
                        newRow < row &&
                        newCol >= 0 &&
                        newCol < col) {

                        /*
                         * We only want to visit an empty room.
                         *
                         * Integer.MAX_VALUE represents INF.
                         *
                         * -1  → wall
                         *  0  → treasure
                         * INF → empty room not processed yet
                         */
                        if (grid[newRow][newCol] == Integer.MAX_VALUE) {

                            /*
                             * Current cell's distance + 1
                             * gives the distance of the neighbour.
                             */
                            grid[newRow][newCol] =
                                grid[current.x][current.y] + 1;

                            /*
                             * Add the newly discovered room
                             * to the queue.
                             */
                            queue.offer(new Pair(newRow, newCol));
                        }
                    }
                }
            }

            /*
             * The entire current BFS level is now processed.
             *
             * The queue now contains the next level.
             *
             * We don't actually need a separate 'distance'
             * variable because we are storing the distance
             * directly inside grid.
             */
        }
    }


    // Stores the coordinates of a cell.
    class Pair {

        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}