class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1=nums1.length;
        int len2=nums2.length;
        int[] arry1=null;
        int[] arry2=null;

        if(len1<len2){
            arry1=nums1;
            arry2=nums2;
        }else{
            arry1=nums2;
            arry2=nums1;
        }

        int mid=(len1+len2)/2;

        int l1=0;
        int r1=arry1.length;

        

        while(l1<=r1){
           int partition1=(l1+r1)/2;
           int countA1=partition1;
           int leftSize=(len1+len2+1)/2;
           int countA2=leftSize-countA1;
           
           int el1=Integer.MIN_VALUE;
           if(partition1>0){
               el1=arry1[partition1-1];
           }
           int er1=Integer.MAX_VALUE;
           if((partition1)<=(arry1.length-1)){
            er1=arry1[partition1];
           }
           int er2= Integer.MAX_VALUE;

           int el2=Integer.MIN_VALUE;

           if((countA2-1)>=0){
               el2=arry2[countA2-1];
           }

           if((countA2)<arry2.length){
               er2= arry2[countA2];
           }

           if(el1<=er2&&el2<=er1){
            if((len1+len2)%2==0){
              int e1=Math.max(el1,el2);
              int e2=Math.min(er1,er2);
              System.out.println(e1+" "+e2);
              return ((e1+e2)*1d)/2;
            }else{
                return Math.max(el1,el2);
            }
           }else if(el1>er2){
             r1=partition1-1;
           }else{
            l1=partition1+1;
           }

        }

        //arry1 element not req

        int totalLen=len1+len2;

        if(totalLen%2==0){
          double median=(arry2[totalLen/2-1]+arry2[totalLen/2])*1d/2;
          return median;

        }else{
            return arry2[totalLen/2];
        }


        
        
    }

}
