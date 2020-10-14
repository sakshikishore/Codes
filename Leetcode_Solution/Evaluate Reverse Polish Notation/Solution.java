class Solution {
    public int evalRPN(String[] tokens) {
        String str="+-*/";
        int result=0;
        Stack<Integer> stck=new Stack<Integer>();
        for(int i=0;i<tokens.length;i++)
        {
            if(str.contains(tokens[i]))
            {
                int q=stck.pop();
                int p=stck.pop();
                if(tokens[i].equals("+"))
                {
                    stck.push(p+q);
                }
                else if(tokens[i].equals("-"))
                {
                    stck.push(p-q);
                }
                else if(tokens[i].equals("*"))
                {
                    stck.push(p*q);
                }
                else
                {                 
                    stck.push(p/q);
                }
            }
            else
            {
                stck.push(Integer.parseInt(tokens[i]));
            }
        }
        
        result=stck.pop();
        return result;
        
    }
}
