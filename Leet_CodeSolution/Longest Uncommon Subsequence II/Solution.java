class Solution {
    HashMap<String,ArrayList<Integer>> h=new HashMap<String,ArrayList<Integer>>();
    public void Solve(String s, int i,String res,int index)
    {
          if(i>=s.length())
          {
            if(!h.containsKey(res))
            {
                ArrayList<Integer> list=new ArrayList<Integer>();
                list.add(index);
                h.put(res,list);
            }
            else
            {
                ArrayList<Integer> list=h.get(res);
                if(list.get(list.size()-1)!=index)
                {
                    list.add(index);
                     h.put(res,list);
                }
            }
            return;
          }

          Solve(s,i+1,res+s.charAt(i),index);
          Solve(s,i+1,res,index);
    }
    public int findLUSlength(String[] strs) {
      for(int i=0;i<strs.length;i++)
      {
        Solve(strs[i],0,"",i);
      }
      int max=-1;
      for(Map.Entry<String,ArrayList<Integer>> entry:h.entrySet())
      {
        String s=entry.getKey();
        ArrayList<Integer> val=entry.getValue();
        if(val.size()==1)
        {
            if(s.length()>max)
            {
                max=s.length();
            }
        }
      }

      return max;

    }
}
