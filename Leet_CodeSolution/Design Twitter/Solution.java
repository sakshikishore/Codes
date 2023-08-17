class Twitter {
   HashMap<Integer,Integer> tweetTime;
   HashMap<Integer,ArrayList<Integer>> userTweetRecord=new HashMap<Integer,ArrayList<Integer>>();
   HashMap<Integer,ArrayList<Integer>> userFollow=new HashMap<Integer,ArrayList<Integer>>();
   int time=0;
    public Twitter() {
        tweetTime=new HashMap<Integer,Integer>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetTime.put(time,tweetId);
        if(!userTweetRecord.containsKey(userId))
        {
            ArrayList<Integer> l=new ArrayList<Integer>();
            l.add(time);
            userTweetRecord.put(userId,l);
        }
        else
        {
             ArrayList<Integer> l=userTweetRecord.get(userId);
            l.add(time);
            userTweetRecord.put(userId,l);
        }
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
       ArrayList<Integer> result=new ArrayList<Integer>();
       ArrayList<Integer> list=userTweetRecord.get(userId);
       ArrayList<Integer> l=new ArrayList<Integer>();
       if(userTweetRecord.containsKey(userId))
       {
           if(list.size()>10)
           {
                 int i=list.size()-1;
                 int count=0;
                 while(count<10)
                 {
                     l.add(list.get(i));
                     i--;
                     count++;
                 }
           }
           else
            {
                for(int i=list.size()-1;i>=0;i--)
                {
                    l.add(list.get(i));
                }
            }
       }
            if(!userFollow.containsKey(userId))
            {
                for(int i=0;i<l.size();i++)
                {
                     result.add(tweetTime.get(l.get(i)));
                }

                return result;
            }
            else
            {
                ArrayList<Integer> followeeId=userFollow.get(userId);
                for(int i=0;i<followeeId.size();i++)
                {
                    int id=followeeId.get(i);
                       if(userTweetRecord.containsKey(id))
                        {
                           list=userTweetRecord.get(id);
                           for(int j=list.size()-1;j>=0 && j>=list.size()-10;j--)
                           {
                               l.add(list.get(j));
                           }
                        }

                }
                Collections.sort(l);
                for(int i=l.size()-1;i>=0 && i>=l.size()-10;i--)
                {
                    result.add(tweetTime.get(l.get(i)));
                }

                return result;

            }

    }
    
    public void follow(int followerId, int followeeId) {
        if(!userFollow.containsKey(followerId))
        {
            ArrayList<Integer> list=new ArrayList<Integer>();
            list.add(followeeId);
            userFollow.put(followerId,list);
        }
        else
        {
            int flag=0;
            ArrayList<Integer> list=userFollow.get(followerId);
            int low=0,high=list.size()-1,index=0;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(list.get(mid)==followeeId)
                {
                    flag=-1;
                    break;
                }
                if(list.get(mid)>followeeId)
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
            if(flag==0)
            {
            list.add(index,followeeId);
            userFollow.put(followerId,list);
            }
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(userFollow.containsKey(followerId))
        {
            ArrayList<Integer> list=userFollow.get(followerId);
            if(list.size()==1)
            {
                if(list.get(0)==followeeId)
                {
                   userFollow.remove(followerId);
                }
            }
            else
            {
                int low=0,high=list.size()-1;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    if(list.get(mid)==followeeId)
                    {
                        list.remove(mid);
                        break;
                    }
                    else if(list.get(mid)>followeeId)
                    {
                        high=mid-1;
                    }
                    else
                    {
                        low=mid+1;
                    }
                }
            }
        }
    }
}
