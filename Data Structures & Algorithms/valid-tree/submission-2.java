class Solution {

    public boolean validTree(int n, int[][] edges) {

        // ---------------------------------------------------------
        // A valid tree must satisfy TWO conditions:
        //
        // 1. It must not contain a cycle.
        // 2. It must be fully connected.
        //
        // We'll use DFS + parent tracking to detect cycles.
        // ---------------------------------------------------------

        // Build undirected adjacency list
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());

            // Undirected graph
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }


        boolean[] visited = new boolean[n];


        // ---------------------------------------------------------
        // Start DFS from node 0.
        //
        // If the graph is disconnected, some nodes won't be
        // visited.
        // ---------------------------------------------------------
        if (!dfs(0, -1, visited, adjList)) {
            return false;
        }


        // ---------------------------------------------------------
        // Check if every node was visited.
        //
        // If some node is unvisited, graph is disconnected.
        // ---------------------------------------------------------
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                return false;
            }
        }


        // No cycle + fully connected = valid tree
        return true;
    }


    private boolean dfs(
            int node,
            int parent,
            boolean[] visited,
            Map<Integer, List<Integer>> adjList) {


        // ---------------------------------------------------------
        // If we reach an already visited node, we found a cycle.
        // ---------------------------------------------------------
        if (visited[node]) {
            return false;
        }

        visited[node] = true;


        // Get all neighbors
        List<Integer> neighbors =
                adjList.getOrDefault(node, new ArrayList<>());


        for (int neighbor : neighbors) {

            // In an undirected graph, ignore the edge back to
            // the node from which we came.
            if (neighbor == parent) {
                continue;
            }


            // If DFS detects a cycle, propagate false.
            if (!dfs(neighbor, node, visited, adjList)) {
                return false;
            }
        }


        return true;
    }
}