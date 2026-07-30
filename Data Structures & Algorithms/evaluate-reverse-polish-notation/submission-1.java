class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<tokens.length;i++){
            String s=tokens[i];

            if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
                    int o1=stack.pop();
                    int o2=stack.pop();
                if(s.equals("+")){
                    stack.push(o1+o2);
                }else if(s.equals("*")){
                    stack.push(o1*o2);
                }else if(s.equals("/")){
                    stack.push(o2/o1);
                }else{
                    stack.push(o2-o1);
                }
                System.out.println("o1 :"+o1+" o2 :"+o2);

            }else{
                stack.push(Integer.parseInt(s));
            }

        }
        return stack.pop();
    }
}
