class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int time=0;
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        Stack<Integer> st=new Stack<Integer>();
        for(int i=0;i<logs.size();i++)
        {
            String str[]=logs.get(i).split(":");
            int t=Integer.parseInt(str[2]);
            int id=Integer.parseInt(str[0]);
            if(str[1].equals("start"))
            {
                if(st.size()>0)
                {
                    int x=t-time;
                    int previd=st.peek();
                    if(!h.containsKey(previd))
                    {
                        h.put(previd,x);
                    }
                    else
                    {
                        h.put(previd,h.get(previd)+x);
                    }
                }
                st.push(id);
                time=t;
            }
            else
            {
                    int  x=t-time+1;
                    int previd=st.pop();
                    if(!h.containsKey(previd))
                    {
                        h.put(previd,x);
                    }
                    else
                    {
                        h.put(previd,h.get(previd)+x);
                    }
                
                time=t+1;
                
            }
        }
        
        int result[]=new int[h.size()];
        int i=0;
        for(Map.Entry<Integer,Integer> entry:h.entrySet())
        {
            result[i]=entry.getValue();
            i++;
        }
        
        return result;
    }
}
