class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();

        for(String str:strs){
            int len=str.length();
            sb.append(len);
            sb.append("#");
            sb.append(str);
        }

        return sb.toString();

    }

    public List<String> decode(String str) {
        System.out.println(str);
        int len=str.length();

        int i=0;
        List<String> ans=new ArrayList<>();
        while(i<len){
            System.out.println("index :"+i);
            StringBuilder sb=new StringBuilder();
            while(i<len&&str.charAt(i)!='#'){
               sb.append(str.charAt(i));
               i++;
            }

            
           
            int currLen=Integer.parseInt(sb.toString());
            System.out.println("index :"+i+" curLen :"+currLen);
            String subStr=str.substring(i+1,i+1+currLen);
            ans.add(subStr);
            i=i+currLen+1;
        }
        return ans;

    }
}
