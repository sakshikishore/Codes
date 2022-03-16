class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        boolean result=false;
        Stack<Integer> stck=new Stack<Integer>();
        int i=0;
        int j=0;
        while(i<pushed.length)
        {
            if(pushed[i]==popped[j])
            {
                j++;
                i++;
            }
            else
            {
                if(stck.size()>0 && popped[j]==stck.peek())
                {
                    j++;
                    stck.pop();
                }
                else
                {
                    stck.push(pushed[i]);
                    i++;
                }
            }
        }
        if(i==pushed.length)
        {
            while(j<popped.length)
            {
                if(popped[j]==stck.peek())
                {
                    stck.pop();
                    j++;
                }
                else
                {
                    break;
                }
            }
        }
        
        if(stck.empty())
        {
            result=true;
        }
        
        return result;
    }
}
