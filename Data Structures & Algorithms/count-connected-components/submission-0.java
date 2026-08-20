class Solution {
    public int countComponents(int n, int[][] edges) {



         boolean visited[]=new boolean[n];

        Map<Integer,List<Integer>> adjList=new HashMap<>();

        for(int i=0;i<edges.length;i++){
            int edge[]=edges[i];

            if(adjList.get(edge[0])==null){
                adjList.put(edge[0],new ArrayList<>());
            }

            if(adjList.get(edge[1])==null){
                adjList.put(edge[1],new ArrayList<>());
            }

            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean res=true;

        int comp=0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
               comp++;
               dfs(i,visited,adjList,-1);
            }
        }

        return comp;

    }



        private void dfs(int node,boolean[] visited,Map<Integer,List<Integer>> adjList,int parent){

        visited[node]=true;

        List<Integer> nebs=adjList.get(node);

        if(nebs==null) return;



        for(int neb:nebs){
            if(!visited[neb]){
                dfs(neb,visited,adjList,node);
            }

        }
    }
}





