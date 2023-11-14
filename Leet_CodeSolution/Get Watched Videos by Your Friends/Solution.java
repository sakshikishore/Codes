class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
           ArrayList<String> result=new ArrayList<String>();
            HashSet<Integer> hset=new HashSet<Integer>();
            Queue<String> q=new LinkedList<String>();
            q.add(Integer.toString(id)+" "+Integer.toString(0));
            HashMap<String,Integer> map=new HashMap<String,Integer>();
            hset.add(id);
            while(q.size()>0)
            {
               String str[]=q.poll().split(" ");
               int x=Integer.parseInt(str[0]);
               int l=Integer.parseInt(str[1]);
               if(l+1<=level)
               {
                for(int i=0;i<friends[x].length;i++)
                {
                    if(!hset.contains(friends[x][i]))
                    {
                        hset.add(friends[x][i]);
                        q.add(Integer.toString(friends[x][i])+" "+Integer.toString(l+1));
                        if(l+1==level)
                        {
                            for(int j=0;j<watchedVideos.get(friends[x][i]).size();j++)
                            {
                                    if(!map.containsKey(watchedVideos.get(friends[x][i]).get(j)))
                                    {
                                        map.put(watchedVideos.get(friends[x][i]).get(j),1);
                                    }
                                    else
                                    {
                                        map.put(watchedVideos.get(friends[x][i]).get(j),map.get(watchedVideos.get(friends[x][i]).get(j))+1);
                                    }
                            }
                        }
                    }
                }
               }
            }
            PriorityQueue<Integer> pq= new PriorityQueue<Integer>();
            HashMap<Integer,ArrayList<String>> h=new HashMap<Integer,ArrayList<String>>();
            for(Map.Entry<String,Integer> entry:map.entrySet())
            {
                 String key=entry.getKey();
                 int val=entry.getValue();
                 if(!h.containsKey(val))
                 {
                     pq.add(val);
                     ArrayList<String> list=new ArrayList<String>();
                     list.add(key);
                     h.put(val,list);
                 }
                 else
                 {
                     ArrayList<String> list=h.get(val);
                     list.add(key);
                     h.put(val,list); 
                 }
            }
            while(pq.size()>0)
            {
                int x=pq.poll();
                ArrayList<String> list=h.get(x);
                Collections.sort(list);
                for(int i=0;i<list.size();i++)
                {
                    result.add(list.get(i));
                }
            }

            return result;

    }
}
