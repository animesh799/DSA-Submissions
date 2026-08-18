class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // ---------------------------------------------------------
        // Build the graph
        //
        // prerequisites[i] = [course, prerequisite]
        //
        // Example:
        // [1, 0] means:
        //     0 -> 1
        //
        // We can take course 1 only after completing course 0.
        // ---------------------------------------------------------
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] edge : prerequisites) {

            int prerequisite = edge[1];
            int course = edge[0];

            // Create the adjacency list if it doesn't exist
            if (!adjList.containsKey(prerequisite)) {
                adjList.put(prerequisite, new ArrayList<>());
            }

            // prerequisite -> course
            adjList.get(prerequisite).add(course);
        }


        // ---------------------------------------------------------
        // visited[node] = true
        //
        // Means:
        // "We have already completely explored this node."
        //
        // If we encounter it again, we don't need to DFS it again.
        // This prevents TLE due to repeated traversal.
        // ---------------------------------------------------------
        boolean[] visited = new boolean[numCourses];


        // ---------------------------------------------------------
        // path contains nodes that are currently present in the
        // DFS recursion stack.
        //
        // Example:
        //
        // 0 -> 1 -> 2
        //
        // While DFS is at 2:
        //
        // path = {0, 1, 2}
        //
        // If 2 points back to 0:
        //
        // 2 -> 0
        //
        // 0 is already inside path => CYCLE!
        // ---------------------------------------------------------
        Set<Integer> path = new HashSet<>();


        // ---------------------------------------------------------
        // There may be multiple disconnected components.
        //
        // So we need to start DFS from every unvisited node.
        // ---------------------------------------------------------
        for (int i = 0; i < numCourses; i++) {

            if (!visited[i]) {

                // If DFS finds a cycle, we cannot finish all courses.
                if (!dfs(i, visited, adjList, path)) {
                    return false;
                }
            }
        }

        // No cycle found
        return true;
    }


    private boolean dfs(
            int node,
            boolean[] visited,
            Map<Integer, List<Integer>> adjList,
            Set<Integer> path) {


        // ---------------------------------------------------------
        // CASE 1:
        //
        // Node is already present in the CURRENT DFS path.
        //
        // Example:
        //
        // 0 -> 1 -> 2
        //      ^    |
        //      |____|
        //
        // When DFS reaches 1 again:
        //
        // path = {0, 1, 2}
        //
        // 1 is already in path => cycle.
        // ---------------------------------------------------------
        if (path.contains(node)) {
            return false;
        }


        // ---------------------------------------------------------
        // CASE 2:
        //
        // Node was already completely explored in a previous DFS.
        //
        // We don't need to explore it again.
        //
        // IMPORTANT:
        //
        // visited != cycle
        //
        // A visited node is only a problem if it is ALSO in
        // the current recursion path.
        // ---------------------------------------------------------
        if (visited[node]) {
            return true;
        }


        // ---------------------------------------------------------
        // Mark node as visited.
        //
        // This prevents us from traversing this node repeatedly
        // from different branches.
        // ---------------------------------------------------------
        visited[node] = true;


        // ---------------------------------------------------------
        // Add node to current DFS recursion path.
        // ---------------------------------------------------------
        path.add(node);


        // Get all courses that depend on this course.
        List<Integer> neighbors = adjList.get(node);


        // ---------------------------------------------------------
        // If there are no neighbors, this node has no outgoing
        // edges.
        //
        // DFS is finished for this node.
        // So remove it from the current path before returning.
        // ---------------------------------------------------------
        if (neighbors == null) {

            path.remove(node);

            return true;
        }


        // ---------------------------------------------------------
        // Explore all neighbors.
        // ---------------------------------------------------------
        for (Integer neighbor : neighbors) {

            // If any neighbor detects a cycle,
            // immediately return false.
            if (!dfs(neighbor, visited, adjList, path)) {

                // Backtracking:
                // remove current node from recursion path.
                path.remove(node);

                return false;
            }
        }


        // ---------------------------------------------------------
        // DFS for this node is completely finished.
        //
        // IMPORTANT:
        //
        // Remove it from path because it is no longer in the
        // current recursion stack.
        //
        // But DO NOT set visited[node] = false.
        //
        // visited remains true because this node has already
        // been completely processed.
        // ---------------------------------------------------------
        path.remove(node);


        return true;
    }
}