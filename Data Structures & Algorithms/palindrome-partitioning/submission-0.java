class Solution {
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> partition(String s) {
        generate(0,new StringBuilder(),new ArrayList<>(),s);
        return res;
        
    }

    private void generate(int idx,StringBuilder sb,List<String> set,String s){
       


        if(idx==s.length()){
            if(isPalindrome(sb.toString())&&sb.length()!=0){
                set.add(sb.toString());
                res.add(new ArrayList<>(set));
                set.remove(set.size()-1);   
            }
            
            return;
        }
         

         char ch=s.charAt(idx);
         sb.append(ch);
        //split
        if(isPalindrome(sb.toString())){
                set.add(sb.toString());
                generate(idx+1,new StringBuilder(),set,s);
                set.remove(set.size()-1);
            }

 


        


        //not split
        
        generate(idx+1,sb,set,s);
        sb.deleteCharAt(sb.length()-1);

    }

    private boolean isPalindrome(String s){
        int i=0,j=s.length()-1;

        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
               return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
