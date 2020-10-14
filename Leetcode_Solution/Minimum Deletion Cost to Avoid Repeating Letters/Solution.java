class Solution {
    public int minCost(String s, int[] cost) {
        Stack<Character> stck=new Stack<Character>();
        Stack<Integer> value=new Stack<Integer>();
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(stck.empty())
            {
                stck.push(s.charAt(i));
                value.add(cost[i]);
            }
            else
            {
                char top=stck.peek();
                if(top==s.charAt(i))
                {
                    if(cost[i]>value.peek())
                    {
                        count=count+value.pop();
                        value.push(cost[i]);
                    
                    }
                    else
                    {
                        count=count+cost[i];
                    }
                }
                else
                {
                    stck.push(s.charAt(i));
                    value.add(cost[i]);
                }
                
            }
        }
        
        return count;
        
    }
}
