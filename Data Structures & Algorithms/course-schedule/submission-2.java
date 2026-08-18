class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer,List<Integer>> adjList=new HashMap<>();
        Set<Integer> path=new HashSet<>();

        for(int i=0;i<prerequisites.length;i++){
            int[] edge=prerequisites[i];

            if(!adjList.containsKey(edge[1])){
                adjList.put(edge[1],new ArrayList<>());
            }

            adjList.get(edge[1]).add(edge[0]);

        }

        System.out.println(adjList);



        boolean flag=true;
        boolean visited[]=new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
               flag=flag&dfs(i,visited,adjList,path);
               if(!flag) return flag;
            }
            

        }

        return flag;
        
    }

    private boolean dfs(int node,boolean[] visited,Map<Integer,List<Integer>> adjList,Set<Integer> path){
     //   System.out.println("node:"+node);
        if(path.contains(node)){

            
            return false;
        }

     if(visited[node]){

            
            return true;
        }


        List<Integer> nebs=adjList.get(node);
        boolean flag=true;
        visited[node]=true;
        path.add(node);

        if(nebs==null){
          path.remove(node);
          return true;
        } 
        
        for(Integer neb:nebs){
            flag=flag&&dfs(neb,visited,adjList,path);
            
        }

        path.remove(node);


       return flag;

    }
}
