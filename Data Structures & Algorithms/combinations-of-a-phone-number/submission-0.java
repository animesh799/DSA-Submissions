class Solution {
    List<String> res=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return res;

        String map[]=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        generate(0,new StringBuilder(),digits,map);
        return res;


        
    }

    private void generate(int start,StringBuilder sb,String digi,String[] map){
        if(start==digi.length()){
            res.add(sb.toString());
            return;
        }

        char ch=digi.charAt(start);
        int digit=ch-'0';
        String s=map[digit];

        for(int i=0;i<s.length();i++){
            ch=s.charAt(i);
            sb.append(ch);
            generate(start+1,sb,digi,map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
