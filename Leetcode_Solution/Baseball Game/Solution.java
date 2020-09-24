class Solution {
    public int calPoints(String[] ops) {
        int totalSum=0;
        Stack<Integer> stck=new Stack<Integer>();
        for(int i=0;i<ops.length;i++)
        {
            if(ops[i].equals("C"))
            {
                if(!stck.empty())
                {
                    stck.pop();
                }
            }
            else if(ops[i].equals("D"))
            {
                if(!stck.empty())
                {
                    int p=stck.peek();
                    stck.push(2*p);
                }
            }
            else if(ops[i].equals("+"))
            {
                int sum=0;
                if(!stck.empty())
                {
                  int p= stck.pop();
                  sum=sum+p;
                    if(!stck.empty())
                    {
                        sum=sum+stck.peek();
                    }
                    stck.push(p);
                    stck.push(sum);
                  
                }
            }
            else
            {
                stck.push(Integer.parseInt(ops[i]));
            }
        }
        
        while(!stck.empty())
        {
            totalSum+=stck.pop();
        }
        
        return totalSum;
        
    }
}
