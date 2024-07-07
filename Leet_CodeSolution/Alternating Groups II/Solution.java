class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int count=1,result=0;
        for(int i=1;i<colors.length;i++)
        {
            if(colors[i]!=colors[i-1])
            {
                count++;
                if(count==k)
                {
                    result++;
                    count=count-1;
                }
            }
            else
            {
                count=1;
            }
        }
            for(int i=0;i<k-1;i++)
            {
                if(colors[i]!=colors[(i-1+colors.length)%colors.length])
                {
                    count++;
                    if(count==k)
                    {
                    result+=1;
                    count=count-1;
                    }
                }
                else
                {
                    break;
                }
          }

        return result;
        
    }
}
