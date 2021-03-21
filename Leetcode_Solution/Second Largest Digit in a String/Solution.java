class Solution {
    public int secondHighest(String s) {
        int result=-1;
        TreeSet<Integer> t=new TreeSet<Integer>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)>='0' && s.charAt(i)<='9')
            {
                t.add(Integer.parseInt(s.substring(i,i+1)));
            }
        }
        
        if(t.size()>1)
        {
            Iterator<Integer> itr=t.iterator();
            int count=0;
            int p=t.size();
            while(itr.hasNext())
            {
                count++;
                if(count==p-1)
                {
                    result=itr.next();
                    break;
                }
                else
                {
                  itr.next();
                }
                
            }
        }
        
        return result;
    }
}
