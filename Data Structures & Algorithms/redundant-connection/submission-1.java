class Solution {

    public int[] findRedundantConnection(int[][] edges) {

        // ---------------------------------------------------------
        // For this problem:
        // Number of nodes = number of edges
        //
        // Nodes are numbered from 1 to n.
        // DSU uses 0-based indexing, so we'll subtract 1.
        // ---------------------------------------------------------
        DSU dsu = new DSU(edges.length);


        // Process edges one by one
        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0] - 1;
            int v = edges[i][1] - 1;


            // -----------------------------------------------------
            // If union returns false:
            //
            // u and v already belong to the same component.
            //
            // Therefore adding this edge creates a cycle.
            // This is our redundant edge.
            // -----------------------------------------------------
            if (!dsu.union(u, v)) {

                return new int[]{
                    edges[i][0],
                    edges[i][1]
                };
            }
        }


        // Should never happen for valid input
        return new int[]{-1, -1};
    }


    // =============================================================
    // DSU / Union-Find
    // =============================================================
    class DSU {

        // Parent of every node
        int[] parent;

        // Rank of each component's root
        int[] rank;


        DSU(int n) {

            parent = new int[n];
            rank = new int[n];


            // Initially every node is its own component.
            //
            // Example:
            //
            // 0    1    2    3
            // |    |    |    |
            // 0    1    2    3
            //
            // Each node is its own parent.
            for (int i = 0; i < n; i++) {

                parent[i] = i;

                // Initial rank
                rank[i] = 1;
            }
        }


        // ---------------------------------------------------------
        // Find the root/representative of a node.
        //
        // Path compression makes future find operations faster.
        // ---------------------------------------------------------
        int findParent(int node) {

            if (parent[node] == node) {
                return node;
            }

            // Path compression
            parent[node] = findParent(parent[node]);

            return parent[node];
        }


        // ---------------------------------------------------------
        // Union two nodes.
        //
        // Returns:
        //
        // true  -> successfully merged two different components
        //
        // false -> nodes already belong to same component
        //          => adding edge creates a cycle
        // ---------------------------------------------------------
        boolean union(int x, int y) {

            int rootX = findParent(x);
            int rootY = findParent(y);


            // -----------------------------------------------------
            // Same root means x and y are already connected.
            //
            // Adding this edge creates a cycle.
            // -----------------------------------------------------
            if (rootX == rootY) {
                return false;
            }


            // -----------------------------------------------------
            // Union by Rank
            //
            // Attach the smaller tree under the larger tree.
            // This keeps the DSU tree shallow.
            // -----------------------------------------------------
            if (rank[rootX] < rank[rootY]) {

                parent[rootX] = rootY;

            }
            else if (rank[rootX] > rank[rootY]) {

                parent[rootY] = rootX;

            }
            else {

                // Same rank:
                // Attach rootY under rootX
                parent[rootY] = rootX;

                // Height/rank increases
                rank[rootX]++;
            }


            return true;
        }
    }
}