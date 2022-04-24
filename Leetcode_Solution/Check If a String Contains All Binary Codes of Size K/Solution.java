class Solution {
    public boolean hasAllCodes(String s, int k) {
        boolean result=true;
        TreeSet<Integer> t=new TreeSet<Integer>();
        if(s.length()>k)
        {
            int i=0;
            while(i<=s.length())
            {
                if(i+k<=s.length())
                {
                    t.add(Integer.parseInt(s.substring(i,i+k),2));
                    i=i+1;
                }
                else
                {
                    break;
                }
            }
            if(t.size()<(int)Math.pow(2,k))
            {
                result=false;
            }
            else
            {
                int j=0;
                for(int x:t)
                {
                    if(x!=j)
                    {
                        result=false;
                        break;
                    }
                    else
                    {
                        j++;
                    }
                }
            }
        }
        else
        {
            result=false;
        }
        
        return result;
        
    }
}
