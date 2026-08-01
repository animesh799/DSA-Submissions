class Solution {
    List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb=new StringBuilder();
        generate(1,sb,n,1,1);
        return res;
        
    }


    private void generate(int i,StringBuilder sb,int n,int open,int close){


        if(i>2*n){
            res.add(sb.toString());
            return;
        }

        if(open<=n){
            sb.append("(");
            generate(i+1,sb,n,open+1,close);
            sb.deleteCharAt(sb.length()-1);
        }

        if(open>close){
            sb.append(")");
            generate(i+1,sb,n,open,close+1);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
