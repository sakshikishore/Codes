class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        if(startTime.length==1)
        {
            return eventTime-(endTime[0]-startTime[0]);
        }
        int start=0;
        int pref[]=new int[startTime.length];
        int suf[]=new int[startTime.length];
        for(int i=0;i<startTime.length;i++)
            {
                if(startTime[i]==start)
                {
                    start=endTime[i];
                    if(i!=0)
                    {
                        pref[i]=pref[i-1];
                    }
                }
                else
                {
                   int diff=startTime[i]-start;
                    if(i==0)
                    {
                    pref[i]=diff;
                    }
                    else
                    {
                        if(diff>pref[i-1])
                        {
                            pref[i]=diff;
                        }
                        else
                        {
                            pref[i]=pref[i-1];
                        }
                    }
                    start=endTime[i];
                }
            }
        int end=eventTime;
        for(int i=endTime.length-1;i>=0;i--)
            {
                if(endTime[i]==end)
                {
                    end=startTime[i];
                    if(i!=endTime.length-1)
                    {
                        suf[i]=suf[i+1];
                    }
                }
                else
                {
                   int diff=end-endTime[i];
                    if(i==endTime.length-1)
                    {
                    suf[i]=diff;
                    }
                    else
                    {
                        if(diff>suf[i+1])
                        {
                            suf[i]=diff;
                        }
                        else
                        {
                            suf[i]=suf[i+1];
                        }
                    }
                    end=startTime[i];
                }
            }
      int max=0;
      for(int i=0;i<startTime.length;i++)
      {
        if(i==0)
        {
            if(startTime[i]==0)
            {
                if(startTime[1]-endTime[0]>max)
                {
                    max=startTime[1]-endTime[0];
                }
                if(suf[i+1]>=(endTime[0]-startTime[0]))
                {
                    max=Math.max(max,startTime[1]);
                }
            }
            else
            {
                if(suf[i+1]>=(endTime[0]-startTime[0]))
                {
                    max=Math.max(max,startTime[1]);
                }
                int diff=endTime[0]-startTime[0];
                if(startTime[1]-diff>max)
                {
                    max=startTime[1]-diff;
                }
            }
        }
        else if(i==startTime.length-1)
        {
            if(endTime[i]==eventTime)
            {
                if(startTime[i]-endTime[i-1]>max)
                {
                    max=startTime[i]-endTime[i-1];
                }
                if(pref[i-1]>=(endTime[i]-startTime[i]))
                {
                    if(eventTime-endTime[i-1]>max)
                    {
                        max=eventTime-endTime[i-1];
                    }
                }
            }
            else
            {
                int diff=endTime[i]-startTime[i];
                int x=eventTime-diff;
                if(x-endTime[i-1]>max)
                {
                    max=x-endTime[i-1];
                }
                if(pref[i-1]>=(endTime[i]-startTime[i]))
                {
                    if(eventTime-endTime[i-1]>max)
                    {
                        max=eventTime-endTime[i-1];
                    }
                }
            }
        }
            else
            {
                if(startTime[i]-endTime[i-1]>max)
                {
                    max=startTime[i]-endTime[i-1];
                }
                if(startTime[i+1]-endTime[i]>max)
                {
                    max=startTime[i+1]-endTime[i];
                }
                if(pref[i-1]>=(endTime[i]-startTime[i]) || suf[i+1]>=(endTime[i]-startTime[i]))
                {
                    if(startTime[i+1]-endTime[i-1]>max)
                    {
                        max=startTime[i+1]-endTime[i-1];
                    }
                }
                int diff=startTime[i]-endTime[i-1]+(startTime[i+1]-endTime[i]);
                if(diff>max)
                {
                    max=diff;
                }
            }
            
      }
       
       

        return max;
        
    }
}
