class Solution {
    public boolean equalFrequency(String word) {
        int ch[]=new int[26];
        for(int i=0;i<word.length();i++)
        {
            ch[word.charAt(i)-'a']++;
        }
        int y=0;
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<26;i++)
        {
            if(ch[i]==0)
            {
                continue;
            }
            else
            {
               if(!h.containsKey(ch[i]))
               {
                   y=ch[i];
                   h.put(ch[i],1);
               }
               else
               {
                   h.put(ch[i],h.get(ch[i])+1);
               }
            }
        }
    
        if(h.size()==1)
        {
            if(h.containsKey(1))
            {
               return true;
            }
            else
            {
                if(h.get(y)==1)
                {
                    return true;
                }
            }
        }
        if(h.size()==2)
        {
        int key1=-1,value1=-1;
        int key2=-1,value2=-1;
        for(Map.Entry<Integer,Integer> entry:h.entrySet())
        {
            if(key1==-1)
            {
                key1=entry.getKey();
                value1=entry.getValue();
            }
            else
            {
                key2=entry.getKey();
                value2=entry.getValue();
            }
        }
        if(key1>key2)
        {
            if(key1-key2==1)
            {
                if(value1==1)
                {
                    return true;
                }
                else if(value2==1 && key2==1)
                {
                    return true;
                }
            }
            else if(key2==1 && value2==1)
            {
                return true;
            }
        }
        else
        {
            if(key2-key1==1)
            {
                if(value2==1)
                {
                    return true;
                }
                 else if(value1==1 && key1==1)
                {
                    return true;
                }
                
            }
            else if(key1==1 && value1==1)
            {
                return true;
            }
        }
    }
        
        return false;
    }
}
