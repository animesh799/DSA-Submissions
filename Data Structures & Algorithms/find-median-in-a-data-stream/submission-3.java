class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap=new PriorityQueue<>((a,b)->b-a);
        minHeap=new PriorityQueue<>((a,b)->a-b);
        
    }
    
    public void addNum(int num) {

        int sizeMin=minHeap.size();
        int sizeMax=maxHeap.size();

        
        if(sizeMax==0){
            maxHeap.offer(num);
        }else{

            int peek=maxHeap.peek();

            if(peek>=num){
                maxHeap.offer(num);

                if((sizeMax+1)-sizeMin>1){
                    minHeap.offer(maxHeap.poll());
                }

            }else{
                minHeap.offer(num);
                if((sizeMin+1)-sizeMax>0){
                    maxHeap.offer(minHeap.poll());
                }

            }
            
        }
        

        //if maxheap and min heap size eqal
        //peek maxheap> cming element 
        //if yes poll and add in minheap else add in the min heap directly

        //if mazelem>minheap create only one diff 1
        
    }
    
    public double findMedian() {
//System.out.println("maxHeap:"+maxHeap);
//System.out.println("minHeap:"+minHeap);

        int sizeMin=minHeap.size();
        int sizeMax=maxHeap.size();

        //if maxHeap size> minHeap Size then min heap pek is the ans
        if(sizeMax>sizeMin){
            return maxHeap.peek()*1d;
        }else{
            double ans=maxHeap.peek()+minHeap.peek();
            return ans/2;
        }

        //els minheap peek +max heap peek /2 is the ans

    
        
    }
}
