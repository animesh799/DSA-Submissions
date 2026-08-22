class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        DSU dsu=new DSU(edges.length);
        for(int i=0;i<edges.length;i++){
            if(!dsu.union(edges[i][0]-1,edges[i][1]-1)){
               return new int[]{edges[i][0],edges[i][1]};
            }
        }
        return new int[]{-1,-1};
        
    }


    class DSU{
        int rank[];
        int pU[];
        public DSU(int n){
             rank=new int[n];
             pU=new int[n];

             for(int i=0;i<n;i++){
                rank[i]=1;
                pU[i]=i;
             }
        }

        public int findParent(int node){
            return pU[node]=(pU[node]==node?node:findParent(pU[node]));
        }

        public boolean union(int x,int y){
            int xp=findParent(x),yp=findParent(y);
            if(xp!=yp){
                if(rank[xp]<rank[yp]){
                    pU[xp]=yp;
                }else if(rank[xp]>rank[yp]){
                    pU[yp]=xp;
                }else{
                    pU[yp]=xp;
                    rank[xp]++;
                }
               return true;
            }

            return false;
        }
    }
}
