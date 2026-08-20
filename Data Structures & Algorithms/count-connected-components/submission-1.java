class Solution {

    public int countComponents(int n, int[][] edges) {

        // ---------------------------------------------------------
        // Build undirected adjacency list
        // ---------------------------------------------------------
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


        // Keeps track of nodes already visited
        boolean[] visited = new boolean[n];

        int components = 0;


        // ---------------------------------------------------------
        // Every time we find an unvisited node, we have discovered
        // a NEW connected component.
        // ---------------------------------------------------------
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                components++;

                // DFS visits every node belonging to this component
                dfs(i, visited, adjList);
            }
        }

        return components;
    }


    private void dfs(
            int node,
            boolean[] visited,
            Map<Integer, List<Integer>> adjList) {

        // Mark current node as visited
        visited[node] = true;


        // Get all neighbors
        List<Integer> neighbors =
                adjList.getOrDefault(node, new ArrayList<>());


        // Visit all unvisited neighbors
        for (int neighbor : neighbors) {

            if (!visited[neighbor]) {
                dfs(neighbor, visited, adjList);
            }
        }
    }
}