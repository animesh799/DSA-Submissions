class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       wordList.add(beginWord);


        Map<String,List<String>> adjList=new HashMap<>();



        for(int i=0;i<wordList.size();i++){
            String word1=wordList.get(i);

            for(int j=i+1;j<wordList.size();j++){
                String word2=wordList.get(j);
                if(checkEditDistance(word1,word2)){

                    if(adjList.get(word1)==null){
                        adjList.put(word1,new ArrayList<>());
                    }
                    adjList.get(word1).add(word2);

                    if(adjList.get(word2)==null){
                        adjList.put(word2,new ArrayList<>());
                    }
                    adjList.get(word2).add(word1);
                }

            }

        }

        System.out.println(adjList);


        Queue<String> queue=new LinkedList<>();
        Set<String> set=new HashSet<>();

        queue.offer(beginWord);
        set.add(beginWord);
        int trans=1;

        int size=queue.size();
        boolean found=false;

        while(!queue.isEmpty()){
            size=queue.size();

            for(int i=0;i<size;i++){
                String poll=queue.poll();

                List<String> nebs=adjList.get(poll);

                if(nebs!=null){
                    for(String neb:nebs){
                        if(neb.equals(endWord)){
                            found=true;
                            break;
                        }
                        if(set.add(neb)){
                            queue.offer(neb);
                        }
                    }
                }
                if(found) break;

            }
            if(found) break;

            size=queue.size();
            trans++;

        }



       

        return !found?0:trans+1;


        
    }

    private boolean checkEditDistance(String s1,String s2){
        int k=0;
        int p=0;

        while(p<s1.length()){
            char ch1=s1.charAt(p);
            char ch2=s2.charAt(p);
            if(ch1!=ch2) k++;
            if(k>1) break;
            p++;
        }
        return k==1;
    }
}
