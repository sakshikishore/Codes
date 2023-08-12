class TweetCounts {
    HashMap<String,ArrayList<Long>> h;
    public TweetCounts() {
        h=new HashMap<String,ArrayList<Long>>();
    }
    
    public void recordTweet(String tweetName, int time) {
        if(!h.containsKey(tweetName))
        {
            ArrayList<Long> l=new ArrayList<Long>();
            l.add(time*1l);
            h.put(tweetName,l);
        }
        else
        {
            ArrayList<Long> l=h.get(tweetName);
            int low=0,high=l.size()-1,index=0;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(l.get(mid)>(time*1l))
                {
                    index=mid;
                    high=mid-1;
                }
                else
                {
                    index=mid+1;
                    low=mid+1;
                }
            }
            l.add(index,time*1l);
            h.put(tweetName,l);
        }
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startT, int endT) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        long startTime=startT*1l,endTime=endT*1l;
        if(!h.containsKey(tweetName))
        {
            while(startTime<=endTime)
            {
                if(freq.equals("minute"))
                {
                      startTime+=60;
                }
                else if(freq.equals("hour"))
                {
                    startTime+=3600;
                }
                else
                {
                    startTime+=86400;
                }
               res.add(0);
              
            }
            return res;
        }
        ArrayList<Long> l=h.get(tweetName);
        int left=0,right=0;
        int low=0,high=l.size()-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(l.get(mid)>=startTime)
                {
                    left=mid;
                    high=mid-1;
                }
                else
                {
                    left=mid+1;
                    low=mid+1;
                }
            }
            low=0;
            high=l.size()-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(l.get(mid)>endTime)
                {
                    right=mid;
                    high=mid-1;
                }
                else
                {
                    right=mid+1;
                    low=mid+1;
                }
            }
           
            right=right-1;
            int val=86400;
        if(freq.equals("minute"))
        {
            val=60;
        }
        else if(freq.equals("hour"))
        {
            val=3600;
        }
            while(startTime<=endTime)
            {
                if(right<left || l.get(right)<(startTime+60))
                {
                    res.add(right-left+1);
                    startTime+=val;
                    while(startTime<=endTime)
                    {
                         res.add(0);
                         startTime+=val;
                       
                    }
                    break;

                }
                else
                {
                       low=left;
                       high=right;
                       int index=0;
                       while(low<=high)
                       {
                           int mid=(low+high)/2;
                           if(l.get(mid)>=(startTime+val))
                           {
                               index=mid-1;
                               high=mid-1;
                           }
                           else
                           {
                                low=mid+1;
                                index=mid;
                           }
                       }
                       res.add(index-left+1);
                       left=index+1;
                       startTime+=val;

                }

            }
            return res;
        }
        
    
}
