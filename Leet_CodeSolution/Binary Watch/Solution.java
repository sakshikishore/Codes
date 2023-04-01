class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        ArrayList<String> result=new ArrayList<String>();
        if(turnedOn>=9)
        {
            return result;
        }
       
        int hour[]={1,2,4,8};
        int min[]={1,2,4,8,16,32};
        HashMap<Integer,ArrayList<String>> h=new HashMap<Integer,ArrayList<String>>();
        HashMap<Integer,ArrayList<String>> m=new HashMap<Integer,ArrayList<String>>();
        for(int i=0;i<(1<<hour.length);i++)
        {
            int ans=0;
            int count=0;
            for(int j=0;j<hour.length;j++)
            {
                 if((i & (1<<j))>0)
                 {
                     ans+=hour[j];
                     count++;
                 }
            }
            if(ans<12)
            {
                if(!h.containsKey(count))
                {
                    ArrayList<String> l=new ArrayList<String>();
                    l.add(Integer.toString(ans));
                    h.put(count,l);
                }
                else
                {
                    ArrayList<String> l=h.get(count);
                    l.add(Integer.toString(ans));
                    h.put(count,l);
                }
            }

        }

        for(int i=0;i<(1<<min.length);i++)
        {
            int ans=0;
            int count=0;
            for(int j=0;j<min.length;j++)
            {
                 if((i & (1<<j))>0)
                 {
                     ans+=min[j];
                     count++;
                 }
            }
            if(ans<60)
            {
                if(!m.containsKey(count))
                {
                    ArrayList<String> l=new ArrayList<String>();
                    if(ans<10)
                    {
                     l.add("0"+Integer.toString(ans));
                    }
                    else
                    {
                        l.add(Integer.toString(ans));
                    }
                    m.put(count,l);
                }
                else
                {
                    ArrayList<String> l=m.get(count);
                    if(ans<10)
                    {
                     l.add("0"+Integer.toString(ans));
                    }
                    else
                    {
                        l.add(Integer.toString(ans));
                    }
                    m.put(count,l);
                }
            }

        }
        for(int i=0;i<=turnedOn;i++)
        {
           int n=turnedOn-i;
           if(i==0)
           {
               if(m.containsKey(n))
               {
                ArrayList<String> p=m.get(n);
                for(int j=0;j<p.size();j++)
                {
                    String s="0:"+p.get(j);
                    result.add(s);
                }
               }

           }
           else if(n==0)
           {
               if(h.containsKey(i))
               {
                    ArrayList<String> p=h.get(i);
                    for(int j=0;j<p.size();j++)
                    {
                        String s=p.get(j)+":00";
                        result.add(s);
                    }
               }
           }
           else
           {
               if(h.containsKey(i) && m.containsKey(n))
               {
                    ArrayList<String> p=h.get(i);
                    ArrayList<String> q=m.get(n);
                    for(int j=0;j<p.size();j++)
                    {
                       for(int k=0;k<q.size();k++)
                       {
                           String s=p.get(j)+":"+q.get(k);
                           result.add(s);
                       }
                    }
               }
           }
        }
        
        return result;
       

       
    }
}
