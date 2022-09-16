class Solution {
    public int[] canSeePersonsCount(int[] heights) {
       ArrayList<Integer> l=new ArrayList<Integer>();
        int result[]=new int[heights.length];
        for(int i=heights.length-1;i>=0;i--)
        {
            if(l.size()==0)
            {
                result[i]=0;
                l.add(heights[i]);
            }
            else
            {
                int count=0;
                for(int j=l.size()-1;j>=0;j--)
                {
                    if(l.get(j)<heights[i])
                    {
                        count++;
                    }
                    else
                    {
                        count=count+1;
                        break;
                    }
                }
                
                result[i]=count;
                while(l.size()>0 && l.get(l.size()-1)<heights[i])
                {
                    
                        l.remove(l.size()-1);
                    
                }
                
                l.add(heights[i]);
            }
        }
        
        return result;
    }
}
