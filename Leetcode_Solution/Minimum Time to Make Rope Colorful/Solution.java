class Solution {
    public int minCost(String colors, int[] neededTime) {
        int result=0;
        Stack<Integer> stck=new Stack<Integer>();
        stck.push(0);
        for(int i=1;i<colors.length();i++)
        {
            int x=stck.peek();
            if(colors.charAt(x)==colors.charAt(i))
            {
                if(neededTime[i]>neededTime[x])
                {
                    stck.pop();
                    result+=neededTime[x];
                    stck.push(i);
                }
                else
                {
                     result+=neededTime[i];
                }
            }
            else
            {
                stck.push(i);
            }
        }
        
        return result;
    }
}
