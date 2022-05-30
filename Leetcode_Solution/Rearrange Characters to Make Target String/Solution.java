class Solution {
    public int rearrangeCharacters(String s, String target) {
        HashMap<Character,Integer> h=new HashMap<Character,Integer>();
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(!h.containsKey(s.charAt(i)))
            {
                h.put(s.charAt(i),1);
            }
            else
            {
                h.put(s.charAt(i),h.get(s.charAt(i))+1);
            }
        }
        
        int flag=1;
        while(flag==1)
        {        
            for(int i=0;i<target.length();i++)
            {
                if(h.containsKey(target.charAt(i)))
                {
                   if(h.get(target.charAt(i))==1)
                   {
                       h.remove(target.charAt(i));
                   }
                   else
                   {
                        h.put(target.charAt(i),h.get(target.charAt(i))-1);
                   }
                }
                else
                {
                    flag=0;
                    break;
                }
            }
            
            if(flag==1)
            {
                count++;
            }
        }
        
        return count;
    }
}
