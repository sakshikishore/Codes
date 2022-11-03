class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> h=new HashMap<String,Integer>();
        for(int i=0;i<words.length;i++)
        {
            if(!h.containsKey(words[i]))
            {
                h.put(words[i],1);
            }
            else
            {
                h.put(words[i],h.get(words[i])+1);
            }
        }
        int ans=0;
        int flag=0;
        for(int i=0;i<words.length;i++)
        {
           if(words[i].charAt(0)==words[i].charAt(1))
           {
              if(h.containsKey(words[i]))
              {
                   if(h.get(words[i])%2==0)
                   {
                      ans+=h.get(words[i])*2;
                   }
                   else
                   {
                       if(flag==0)
                       {
                            ans+=h.get(words[i])*2;
                            flag=1;
                       }
                       else
                       {
                          ans+=(h.get(words[i])-1)*2; 
                       }
                   }

                   h.remove(words[i]);
              }
           }
           else
           {
              
               String p= words[i].substring(1)+words[i].substring(0,1);
               if(h.containsKey(p) && h.containsKey(words[i]))
               {
                   int x=h.get(p);
                   int y=h.get(words[i]);
                   int min=Math.min(x,y);
                   ans+=4*min;
                   h.remove(p);
                   h.remove(words[i]);
               }
           }
        }
        
        return ans;
    }
}
