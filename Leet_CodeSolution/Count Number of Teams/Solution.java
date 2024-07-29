class Solution {
    public int numTeams(int[] rating) {
        int ans=0;
        for(int i=0;i<rating.length;i++)
        {
            ArrayList<Integer> l=new ArrayList<Integer>();
            for(int j=i+1;j<rating.length;j++)
            {
               if(l.size()==0)
               {
                 l.add(rating[j]);
               }
               else
               {
                 
                    int low=0,high=l.size()-1,lowerIndex=0;
                    while(low<=high)
                    {
                        int mid=(low+high)/2;
                        if(l.get(mid)>rating[j])
                        {
                            lowerIndex=mid;
                            high=mid-1;
                        }
                        else
                        {
                            lowerIndex=mid+1;
                            low=mid+1;
                        }
                    }
                    low=0;
                    high=l.size()-1;
                    int higherIndex=0;
                    while(low<=high)
                    {
                        int mid=(low+high)/2;
                        if(l.get(mid)>rating[i])
                        {
                           higherIndex=mid;
                           high=mid-1;
                        }
                        else
                        {
                            higherIndex=mid+1;
                            low=mid+1;
                        }
                    }
                     if(rating[i]>rating[j])
                  {
                    ans+=higherIndex-lowerIndex;
                  }
                  else
                  {
                    ans+=lowerIndex-higherIndex;
                  }

                  l.add(lowerIndex,rating[j]);
               }
            }
        }

        return ans;
    }
}
