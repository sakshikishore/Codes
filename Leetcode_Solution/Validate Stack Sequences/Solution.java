class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        boolean result=false;
        Stack<Integer> s=new Stack<Integer>();
        if(pushed.length>0)
        {
            s.push(pushed[0]);
        }
        int i=0;
        int j=0;
        while(i<pushed.length && popped.length>j)
        {
            if(s.empty() && i+1<pushed.length)
            {
               i++;
               s.push(pushed[i]);
            }
            else if(s.peek()!=popped[j])
            {
                i++;
                if(i==pushed.length)
                {
                    break;
                }
                s.push(pushed[i]);
            }
            else
            {
                j++;
                s.pop();
            }
        }
        
        if(s.empty() && j==popped.length)
        {
            result=true;
        }
        
        return result;
    }
}
