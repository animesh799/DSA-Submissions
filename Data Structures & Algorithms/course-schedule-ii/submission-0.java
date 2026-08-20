class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer,List<Integer>> adjList=new HashMap<>();

        for(int i=0;i<prerequisites.length;i++){
            int[] edge=prerequisites[i];

            if(!adjList.containsKey(edge[1])){
                adjList.put(edge[1],new ArrayList<>());
            }

            adjList.get(edge[1]).add(edge[0]);
        }

        Map<Integer,Integer> indigree=new HashMap<>();

        for(int i=0;i<numCourses;i++){
            indigree.put(i,0);

        }

        for(Integer key:adjList.keySet()){
            List<Integer> nebs=adjList.get(key);

            for(int neb:nebs){
               int count=indigree.get(neb);
               indigree.put(neb,count+1);
            }

        }

        

        Queue<Integer> queue=new LinkedList<>();
        


        for(int key:indigree.keySet()){
            if(indigree.get(key)==0){
                queue.offer(key);
            }
        }

        System.out.println("map:"+indigree+" Queue Size:"+queue.size());

      //  if(queue.isEmpty()) return new int[]{};

        List<Integer> list=new ArrayList<>();

        while(!queue.isEmpty()){

            Integer poll=queue.poll();
            list.add(poll);

            List<Integer> nebs=adjList.get(poll);

            if(nebs==null) continue;

            for(int neb:nebs){
                indigree.put(neb,(indigree.get(neb)-1));
                int ind=indigree.get(neb);

                if(ind==0){
                  queue.offer(neb);
                }
                
            }
        }

        if(list.size()!=numCourses){
            return new int[]{};
        }

        int res[]=new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);

        }

        return res;




      
        
    }
}
