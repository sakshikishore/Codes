class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stck=new Stack<Integer>();
        for(int i=0;i<asteroids.length;i++)
        {
            if(stck.empty())
            {
                stck.push(asteroids[i]);
            }
            else
            {
                if((stck.peek()>0 && asteroids[i]<0))
                {
                     int p=stck.peek();
                     int q=(-1)*asteroids[i];
                     if(p==q)
                     {
                         stck.pop();
                     }
                     else if(p<q)
                     {
                         stck.pop();
                         i--;
                     }
                }
                else
                {
                    stck.push(asteroids[i]);
                }
            }
        }

        int result[]=new int[stck.size()];
        int i=stck.size()-1;
        while(stck.size()>0)
        {
           result[i]=stck.pop();
           i--;
        }


        return result;

    }
}
