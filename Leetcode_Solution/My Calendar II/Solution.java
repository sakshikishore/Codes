class MyCalendarTwo {
   List<List<Integer>> list;
    public MyCalendarTwo() {
       list=new ArrayList();
    }
    
    public boolean book(int start, int end) {
        boolean result=true;
        if(list.size()==0)
        {
            ArrayList<Integer> l=new ArrayList<Integer>();
            l.add(start);
            l.add(end);
            list.add(l);
        }
        else
        {
            ArrayList<String> l=new ArrayList<String>();
            for(int i=0;i<list.size();i++)
            {
                int key=list.get(i).get(0);
                int val=list.get(i).get(1);
                if((start<key && end<=key) || start>=val && end>val)
                {
                    continue;
                }
                else
                {
                   l.add(Integer.toString(key)+" "+Integer.toString(val));
                }
            }
            if(l.size()<2)
            {
                    ArrayList<Integer> m=new ArrayList<Integer>();
                    m.add(start);
                    m.add(end);
                    list.add(m);
            }
            else
            {
                for(int i=0;i<l.size();i++)
                {
                    String str[]=l.get(i).split(" ");
                    int a=Integer.parseInt(str[0]);
                    int b=Integer.parseInt(str[1]);
                    for(int j=i+1;j<l.size();j++)
                    {
                            String s[]=l.get(j).split(" ");
                            int c=Integer.parseInt(s[0]);
                            int d=Integer.parseInt(s[1]);
                           if((a<c && b<=c )||(a>=d && b>d))
                           {
                               continue;
                           }
                           else
                           {
                               result=false;
                               break;
                           }
                    }
                    
                    if(!result)
                    {
                        break;
                    }
                }
                
                if(result)
                {
                     ArrayList<Integer> m=new ArrayList<Integer>();
                     m.add(start);
                     m.add(end);
                    list.add(m);
                }
            }
        }
        return result;
    }
}
