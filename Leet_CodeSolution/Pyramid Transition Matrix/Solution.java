class Solution {
    HashMap<String,ArrayList<Character>> h=new HashMap<String,ArrayList<Character>>();
    boolean result=false;
    HashSet<String> hset=new HashSet<String>();
    public void Solve(String bottom, String top,int index)
    {
        if(hset.contains(bottom+" "+top))
        {
            return;
        }
        hset.add(bottom+" "+top);
        if(result)
        {
            return;
        }
        if(top.length()==bottom.length()-1)
        {
            if(top.length()==1)
            {
                result=true;
            }
            else
            {
                Solve(top,"",0);
            }
            return;
        }
      
            String s=bottom.substring(index,index+2);
            if(h.containsKey(s))
            {
                ArrayList<Character> l=h.get(s);
                for(int j=0;j<l.size();j++)
                {
                    Solve(bottom,top+l.get(j),index+1);
                }
            }
    }
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for(int i=0;i<allowed.size();i++)
        {
            String s=allowed.get(i).substring(0,2);
            if(!h.containsKey(s))
            {
                ArrayList<Character> list=new ArrayList<Character>();
                list.add(allowed.get(i).charAt(2));
                h.put(s,list);
            }
            else
            {
                ArrayList<Character> list=h.get(s);
                list.add(allowed.get(i).charAt(2));
                h.put(s,list);
            }
        }
        Solve(bottom,"",0);
        return result;
    }
}
