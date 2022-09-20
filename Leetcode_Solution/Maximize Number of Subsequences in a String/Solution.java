class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        long ans=0;
        if(!text.contains(pattern.substring(0,1)) && !text.contains(pattern.substring(1,2)))
        {
            return ans;
        }
        else if(!text.contains(pattern.substring(0,1)))
        {
            
            for(int i=0;i<text.length();i++)
            {
                if(text.charAt(i)==pattern.charAt(1))
                {
                    ans++;
                }
            }
            
            return ans;
        }
        else if(!text.contains(pattern.substring(1,2)))
        {
            
            for(int i=0;i<text.length();i++)
            {
                if(text.charAt(i)==pattern.charAt(0))
                {
                    ans++;
                }
            }
            
            return ans;
        }
        HashMap<Character,ArrayList<Integer>> h=new HashMap<Character,ArrayList<Integer>>();
        for(int i=0;i<text.length();i++)
        {
            if(text.charAt(i)==pattern.charAt(0) || text.charAt(i)==pattern.charAt(1))
            {
                if(!h.containsKey(text.charAt(i)))
                {
                    ArrayList<Integer> l=new ArrayList<Integer>();
                    l.add(i);
                    h.put(text.charAt(i),l);
                }
                else
                {
                    ArrayList<Integer> l=h.get(text.charAt(i));
                    l.add(i);
                    h.put(text.charAt(i),l);
                }
            }
        }
        
        ArrayList<Integer> l1=h.get(pattern.charAt(0));
        ArrayList<Integer> l2=h.get(pattern.charAt(1));
        if(l1.get(l1.size()-1)<l2.get(0))
        {
            long a=1,b=1;
             a=a*(l1.size()+1)*l2.size();
             b=b*(l2.size()+1)*l1.size();
            return Math.max(a,b);
        }
        else
        {
            int j=0;
            for(int i=0;i<l1.size();i++)
            {
                int a=l1.get(i);
                while(j<l2.size())
                {
                    if(l2.get(j)>a)
                    {
                        ans+=l2.size()-j;
                        break;
                    }
                    j++;
                }
            }
            
            long p=Math.max(l1.size(),l2.size());
            ans+=p;
            
            return ans;
        }
            
    }
}
